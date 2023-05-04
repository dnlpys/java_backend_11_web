package test.com.singleton.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

	@Bean
	public TestBean6 test0601() {
		return new TestBean6();
	}
	
	@Bean
	public TestBean6 test0602() {
		return new TestBean6("yang");
	}
	
	@Bean
	public TestBean7 test07() {
		TestBean7 tb = new TestBean7();
		tb.setName("lee");
		return tb;
	}
	
	@Bean
	public TestBean8 test08() {
		return new TestBean8(test07());
	}
	
}
