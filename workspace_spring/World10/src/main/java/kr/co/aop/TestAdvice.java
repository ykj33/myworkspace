package kr.co.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAdvice {

	// joinpoints를 정의하는 advice 생성
	// pointcut이 실행되기 전에 실행
	@Before("execution(* kr.co.service.AOPTestService*.*(..))")
	// pointcut이 실행되기 전에 출력됨
	public void start(JoinPoint jp) {
		System.out.println(":::::::::::::::::::::::::::::::::::");
		System.out.println(jp.getKind());
		System.out.println(jp.getSignature());
		System.out.println(jp.getTarget());
		System.out.println(":::::::::::::::::::::::::::::::::::");
	}

//	pointcut이 실행되기 전에 실행
	@After("execution(* kr.co.service.AOPTestService*.*(..))")
	public void end() {
		System.out.println("**********************************");
	}

	// pointcut 실행전후로 실행
	@Around("execution(* kr.co.service.AOPTestService*.*(..))")
	public void duration(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		
		// 핵심코드로 간주
		pjp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
