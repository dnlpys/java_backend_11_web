package test.com.singleton.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean8 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean8.class);

	private TestBean7 tb;

	public TestBean8() {
		logger.info("TestBean8()....");
	}

	public TestBean8(TestBean7 tb) {
		logger.info("TestBean8(TestBean7 tb)....{}", tb);
		this.tb = tb;
	}

	@Override
	public String toString() {
		return "TestBean8 [tb=" + tb + "]";
	}

}
