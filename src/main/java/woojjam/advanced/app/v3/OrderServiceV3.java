package woojjam.advanced.app.v3;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import woojjam.advanced.trace.TraceStatus;
import woojjam.advanced.trace.logtrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

	private final OrderRepositoryV3 orderRepository;
	private final LogTrace trace;

	public void orderItem(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderService.orderItem()");
			orderRepository.save(itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
