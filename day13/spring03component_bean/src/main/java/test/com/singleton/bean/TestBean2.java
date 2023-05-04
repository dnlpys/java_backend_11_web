package test.com.singleton.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean2 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean2.class);

	private String name = "han";
	private int age = 22;

	public TestBean2() {
		logger.info("TestBean2()....");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "TestBean2 [name=" + name + ", age=" + age + "]";
	}

	public void test2() {
		logger.info("test2()....");
	}
}
