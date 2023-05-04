package test.com.singleton.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean3 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean3.class);

	private TestBean tb;

	public TestBean3() {
		logger.info("TestBean3()....");
	}
	
	public TestBean3(TestBean tb) {
		logger.info("TestBean3()....{}",tb);
		this.tb = tb;
	}

	@Override
	public String toString() {
		return "TestBean3 [tb=" + tb + "]";
	}

	
}
