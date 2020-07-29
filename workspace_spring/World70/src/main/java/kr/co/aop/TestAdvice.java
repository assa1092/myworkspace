package kr.co.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component		// Aspect를 객체로 만드는것.
// 객체로 만드는것 ...@Controller, @Service, @Repository, @Component
@Aspect			// AOP를 위한 Advice라고 알려주는것.
public class TestAdvice {
	
	// @Around 는 반드시 ProceedingJoinPoint pjp 만들어야 한다..무조건
	// 예외 처리도 반드시.... throws Throwable
	@Around("execution(* kr.co.service.AOPTestService*.*(..))")
	public void duration(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		
		pjp.proceed();	// 핵심코드....aoptest3() for문....
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	
	// @After-> AOPTestServiceImpl의 모든 메소드가 실행된 후에... 실행...
	@After("execution(* kr.co.service.AOPTestService*.*(..))")
	public void start() {
		System.out.println("*********************");
	}
	
	// @Before AOPTestServiceImpl의 모든 메소드가 실행되기 전에... 실행...
	// joinpoints 정의, 설정해준다.
	@Before("execution(* kr.co.service.AOPTestService*.*(..))")
	public void start(JoinPoint jp) {	// org.aspectj.lang.JoinPoint;
		System.out.println("::::::::::::::::::::::");
		System.out.println(jp.getKind());		// 어드바이스의 타입을 알수있다.
		System.out.println(jp.getSignature());	// 어떤 객체의 특정 메소드를 보여준다. 
		System.out.println(jp.getTarget());		// 
		System.out.println("::::::::::::::::::::::");
	}
	
}
