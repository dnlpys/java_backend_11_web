package test.com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestAroundAspect {

	@Around("execution(public * test..*DAO*.insert(..))")
	public Object insertAroundAdvice(ProceedingJoinPoint pjp) {
		log.info("insertAroundAdvice()....insert before");
		Object value = null;
		try {
			value = pjp.proceed(); // call insert()
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("insertAroundAdvice()....insert after");

		return value;
	}
	
	@Around("execution(public * test..*DAO*.update(..))")
	public Object updateAroundAdvice(ProceedingJoinPoint pjp) {
		log.info("updateAroundAdvice()....update before");
		Object value = null;
		try {
			value = pjp.proceed(); // call update()
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("updateAroundAdvice()....insert after");
		
		return value;
	}

}
