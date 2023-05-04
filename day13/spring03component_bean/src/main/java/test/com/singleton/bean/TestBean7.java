package test.com.singleton.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean7 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean7.class);

	private String name = "kim7";

	public TestBean7() {
		logger.info("TestBean7()....");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestBean7 [name=" + name + "]";
	}

}
