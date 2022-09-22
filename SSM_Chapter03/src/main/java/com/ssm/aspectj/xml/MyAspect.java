package com.ssm.aspectj.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("Advice Before, the target class is: " + joinPoint.getTarget());
		
		System.out.println(", the added advice method is: " + joinPoint.getSignature().getName());
	}
	
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
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Advice Around, before execution");
		
		Object obj = proceedingJoinPoint.proceed();
		
		System.out.println("Advice Around, after execution");
		
		return obj;
	}
	
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("Advice after throwing, the message is: " + e.getMessage());
	}
	
	public void myAfter() {
		System.out.println("Advice final, is the final after advice!");
	}
	
	
}
