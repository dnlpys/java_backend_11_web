package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestPointCutAspect {
	
	@Pointcut("execution(public * test..*DAO*.delete(..))")
	public void deletePointCut() {}
	
	@Pointcut("execution(public * test..*DAO*.search(..))")
	public void searchPointCut() {}

	@Before("deletePointCut()")
	public void testBeforeAdvice(JoinPoint jp) {
		log.info("testBeforeAdvice()....test before");
	}
	
	@After("deletePointCut()")
	public void testAfterAdvice(JoinPoint jp) {
		log.info("testAfterAdvice()....test after");
	}
	
	
	
//	@Pointcut("execution(public * test..*DAO*.*(..))")
//	@Pointcut("bean(dao)") //<bean id="dao">
	@Pointcut("within(TestDAOimpl)") //<bean id="dao">
	public void daoPointCut() {}
	
	@After("daoPointCut()")
	public void daoAfterAdvice(JoinPoint jp) {
		log.info("daoAfterAdvice()....dao after");
	}

}
