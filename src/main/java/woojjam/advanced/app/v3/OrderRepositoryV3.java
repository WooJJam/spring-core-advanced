package woojjam.advanced.app.v3;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import woojjam.advanced.trace.TraceStatus;
import woojjam.advanced.trace.logtrace.LogTrace;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

	private final LogTrace trace;
	public void save(String itemId) {

		// 저장 로직
		TraceStatus status = null;
		try {
			status = trace.begin("OrderRepository.save()");
			if (itemId.equals("ex")) {
				throw new IllegalArgumentException("Invalid item ID");
			}
			sleep(1000);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

	private void sleep(int millis)  {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
