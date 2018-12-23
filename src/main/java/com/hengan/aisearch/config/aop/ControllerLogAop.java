package com.hengan.aisearch.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class ControllerLogAop {

    /**
     * 这样写是将重复的代码提取出来方便处理
     */
    @Pointcut("execution(public * com.hengan..control*.*.*(..))")
    public void log() {}

    /**
     * @param joinPoint
     * 注意：该方法中的HttpServletRequest为javax.servlet.http.HttpServletRequest;
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer sb = new StringBuffer();
        sb.append("class_method={"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"}, ");
        sb.append("url={"+request.getRequestURL()+"}, ");
        sb.append("method={"+request.getMethod()+"}, ");
        sb.append("ip={"+request.getRemoteAddr()+"}, ");
        //记录传递的参数
        if(joinPoint.getArgs()!=null && joinPoint.getArgs().length>0){
            for(Object obj: joinPoint.getArgs()){
                if(obj!=null){
                    sb.append("args={"+obj.toString()+"}");
                }
            }
        }
        log.info(sb.toString());
    }

    @After("log()")
    public void doAfter() {
    }

    @AfterReturning(returning = "obj",pointcut = "log()")
    public void doAfterReturning(Object obj) {
        log.info("response={}",obj);
    }


}
