package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestAfterAspect {

	@After("execution(public * test..*DAO*.select(..))")
	public void selectAfterAdvice(JoinPoint jp) {
		log.info("selectAfterAdvice()....select after");
	}
	
	

}
