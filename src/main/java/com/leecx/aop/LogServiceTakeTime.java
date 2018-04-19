package com.leecx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>Title:</p>
 * <p>Description:service的方法执行需要多少时间统计</p>
 * <p>Copyright:Copyright (c) 2018</p>
 * <p>Company:东软集团股份有限公司</p>
 * CreateDate:2018/4/18 0018 下午 23:09
 * Author:段美林[duanml@neusoft.com]
 * Version:1.0
 */
//申明主体类，定义切面主体类
@Aspect
@Component
public class LogServiceTakeTime {
	
	private final static Logger log = LoggerFactory.getLogger(LogServiceTakeTime.class);

	//扫描到具体包下的所有类和方法
	@Pointcut("execution(* com.leecx.service..*.*(..))")
	//扫描到具体包下的所有类的saveUser方法
	//@Pointcut("execution(* com.leecx.service..*.saveUser(..))")
	public void performance(){
	}

	@Around("performance()")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//记录起始时间 
		long begin = System.currentTimeMillis();
		Object result = "";
		/** 执行目标方法 */
		try{
			result= joinPoint.proceed();
		}
		catch(Exception e){
			log.error("日志记录发生错误, errorMessage: {}", e.getMessage());
		}
		finally{
			/** 记录操作时间 */
			long took = System.currentTimeMillis() - begin;
			if (took >= 10000) {
				log.error("Service 执行时间为: {}秒", took);
			} else if (took >= 5000) {
				log.warn("Service 执行时间为: {}秒", took);
			} else  if (took >= 3000) {
				log.info("Service执行时间为: {}秒", took);
			}
			// TODO 日志保存到MongoDB中
		}
        return result;
	}
	
	@Before("performance()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
		log.info("doBefore");
    }
	
    @AfterReturning(returning = "ret", pointcut = "performance()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	log.info("doAfterReturning");
    }
	
}