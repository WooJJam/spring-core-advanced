package woojjam.advanced.app.v2;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import woojjam.advanced.trace.TraceId;
import woojjam.advanced.trace.TraceStatus;
import woojjam.advanced.trace.hellotrace.HelloTraceV2;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

	private final HelloTraceV2 trace;
	public void save(TraceId traceId, String itemId) {

		// 저장 로직
		TraceStatus status = null;
		try {
			status = trace.beginSync(traceId, "OrderRepository.save()");
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
