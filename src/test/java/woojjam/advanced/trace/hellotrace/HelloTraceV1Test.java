package woojjam.advanced.trace.hellotrace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import woojjam.advanced.trace.TraceStatus;

class HelloTraceV1Test {

	@Test
	public void begin_end() throws Exception {
		HelloTraceV1 helloTraceV1 = new HelloTraceV1();
		TraceStatus status = helloTraceV1.begin("hello trace begin");
		Thread.sleep(1000);
		helloTraceV1.end(status);
	}

	@Test
	public void begin_exception() throws Exception {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello trace begin");
		trace.exception(status, new IllegalArgumentException("exception"));
	}
}