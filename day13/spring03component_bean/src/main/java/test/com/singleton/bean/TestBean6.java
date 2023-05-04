package test.com.singleton.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean6 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean6.class);

	private String name = "kim";

	public TestBean6() {
		logger.info("TestBean6()....");
	}

	public TestBean6(String name) {
		logger.info("TestBean6(String name)....{}",name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestBean6 [name=" + name + "]";
	}

}
