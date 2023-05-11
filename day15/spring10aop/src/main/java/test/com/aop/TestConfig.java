package test.com.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	@Bean
	public TestPointCutAspect testPointCutAspect() {
		return new TestPointCutAspect();
	}

}
