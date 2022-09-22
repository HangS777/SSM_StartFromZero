package com.ssm.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* com.ssm.aspectj.*.*(..))")
	public void myPointCut() {}
	
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("Advice Before, the target class is: " + joinPoint.getTarget());
		
		System.out.println(", the added advice method is: " + joinPoint.getSignature().getName());
	}
	
	// 'value' is same as 'pointcut'
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("Advice After Returning, the target class is: " + joinPoint.getTarget());
		
		System.out.println(", the added advice method is: " + joinPoint.getSignature().getName());
	}
	
	/**
	 * 
	 * @param proceedingJoinPoint is a sub interface of JoinPoint, indicates the executable target method
	 * @return Object returning must is a Object type
	 * @throws Throwable must throws Throwable
	 */
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Advice Around, before execution");
		
		Object obj = proceedingJoinPoint.proceed();
		
		System.out.println("Advice Around, after execution");
		
		return obj;
	}
	
	@AfterThrowing(value="myPointCut()", throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("Advice after throwing, the message is: " + e.getMessage());
	}
	
	@After("myPointCut()")
	public void myAfter() {
		System.out.println("Advice final, is the final after advice!");
	}
	
	
}
