package test.com.singleton.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
	private static final Logger logger = LoggerFactory.getLogger(TestBean.class);

	public String name = "lee";
	public int age = 33;
	
	public TestBean() {
		logger.info("TestBean()....");
	}
	public TestBean(String name) {
		logger.info("TestBean(String name)....{}",name);
		this.name = name;
	}
	
	public TestBean(String name,int age) {
		logger.info("TestBean(String name,int age)....{},{}",name,age);
		this.name = name;
		this.age = age;
	}
	
	public void test2() {
		logger.info("test2()....");
	}
	
	@Override
	public String toString() {
		return "TestBean [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
