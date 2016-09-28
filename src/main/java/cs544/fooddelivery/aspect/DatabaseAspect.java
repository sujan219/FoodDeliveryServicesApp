package cs544.fooddelivery.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;

import cs544.fooddelivery.log.LogWriter;

@Aspect
public class DatabaseAspect {
	
	@Autowired
	private LogWriter logWriter;
	
	@Around("execution(* cs544.fooddelivery.repositories..*.*(..))")
	public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		Object obj = joinPoint.proceed();
		sw.stop();
		String message = "Function call: " + joinPoint.getTarget().getClass().getName() + "." 
				+ joinPoint.getSignature().getName() + " took " + " " + sw.getLastTaskTimeMillis() + "ms";
		logWriter.writeInfoLog(message);
		return obj;
	}
	
	@Before("execution(* cs544.fooddelivery.supplier.SupplierService.*(..))")
	public void beforeAnyMethodSupplier(JoinPoint jp){
		System.out.println("before supplier controller method executed:"+jp.getSignature());
	}
}
