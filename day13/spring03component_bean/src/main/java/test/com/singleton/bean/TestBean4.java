package test.com.singleton.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean4 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean4.class);

	private TestBean tb;

	public TestBean4() {
		logger.info("TestBean4()....");
	}

	public TestBean getTb() {
		return tb;
	}

	public void setTb(TestBean tb) {
		this.tb = tb;
	}

	@Override
	public String toString() {
		return "TestBean4 [tb=" + tb + "]";
	}

}
