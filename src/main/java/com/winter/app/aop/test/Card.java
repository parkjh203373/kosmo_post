package com.winter.app.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Card {
	// execution(접근지정자(생략가능) 리턴타입 패키지명.클래스명.메서드명(매개변수타입) )
	@Around("execution(* com.winter.app.aop.test.Transport.take*(*))")
	public Object cardCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("타기 전 Card check");
		
		Object[] ar = proceedingJoinPoint.getArgs();
		log.info("{}", ar);
		
		Object obj = proceedingJoinPoint.proceed();
		log.info("return : {}", obj);
		
		System.out.println("하차 후 Card check");
		
		return obj;
	}

}
