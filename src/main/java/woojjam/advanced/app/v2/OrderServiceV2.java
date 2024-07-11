package woojjam.advanced.app.v2;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import woojjam.advanced.trace.TraceId;
import woojjam.advanced.trace.TraceStatus;
import woojjam.advanced.trace.hellotrace.HelloTraceV1;
import woojjam.advanced.trace.hellotrace.HelloTraceV2;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

	private final OrderRepositoryV2 orderRepository;
	private final HelloTraceV2 trace;

	public void orderItem(TraceId traceId, String itemId) {
		TraceStatus status = null;
		try {
			status = trace.beginSync(traceId, "OrderService.orderItem()");
			orderRepository.save(status.getTraceId(), itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
