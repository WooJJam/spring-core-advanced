package woojjam.advanced.app.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import woojjam.advanced.trace.TraceStatus;
import woojjam.advanced.trace.hellotrace.HelloTraceV1;
import woojjam.advanced.trace.hellotrace.HelloTraceV2;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

	private final OrderServiceV2 orderService;
	private final HelloTraceV2 trace;

	@GetMapping("/v2/request")
	public String request(String itemId) throws InterruptedException {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderController.request()");
			orderService.orderItem(status.getTraceId(),itemId);
			trace.end(status);
			return "OK";
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
    }
}
