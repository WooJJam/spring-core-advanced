package woojjam.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;

import woojjam.advanced.trace.TraceStatus;

class HelloTraceV2Test {

	@Test
	public void begin_end() throws Exception {
		HelloTraceV2 helloTraceV2 = new HelloTraceV2();
		TraceStatus status1 = helloTraceV2.begin("hello trace begin");
		TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(), "hello2");
		helloTraceV2.end(status1);
		helloTraceV2.end(status2);
	}

	@Test
	public void begin_exception() throws Exception {
		HelloTraceV2 trace = new HelloTraceV2();
		TraceStatus status1 = trace.begin("hello trace begin");
		TraceStatus status2 = trace.begin("hello trace begin2");
		trace.exception(status1, new IllegalArgumentException("exception"));
		trace.exception(status2, new IllegalArgumentException("exception"));
	}
}