package woojjam.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import woojjam.advanced.trace.logtrace.FilterLogTrace;
import woojjam.advanced.trace.logtrace.LogTrace;

@Configuration
public class LogTraceConfig {

	@Bean
	public LogTrace logTrace() {
        return new FilterLogTrace();
    }
}
