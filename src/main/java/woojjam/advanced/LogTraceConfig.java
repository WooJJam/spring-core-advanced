package woojjam.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import woojjam.advanced.trace.logtrace.LogTrace;
import woojjam.advanced.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

	@Bean
	public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
