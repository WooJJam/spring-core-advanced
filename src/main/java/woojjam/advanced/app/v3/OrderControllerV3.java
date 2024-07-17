package woojjam.advanced.app.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import woojjam.advanced.trace.TraceStatus;
import woojjam.advanced.trace.logtrace.LogTrace;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

	private final OrderServiceV3 orderService;
	private final LogTrace trace;

	@GetMapping("/v3/request")
	public String request(String itemId) throws InterruptedException {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderController.request()");
			orderService.orderItem(itemId);
			trace.end(status);
			return "OK";
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
    }
}
