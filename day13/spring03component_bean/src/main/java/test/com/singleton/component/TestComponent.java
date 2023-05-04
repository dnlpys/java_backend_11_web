package test.com.singleton.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

	private static final Logger logger = LoggerFactory.getLogger(TestComponent.class);
	
	
	public String name = "kim";
	
	public TestComponent() {
		logger.info("TestComponent()....");
	}
	
	public void test() {
		logger.info("test()....");
	}
	
}
