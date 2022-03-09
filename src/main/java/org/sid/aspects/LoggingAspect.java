package org.sid.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {
    @Around("@annotation(org.sid.aspects.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       long t1=System.currentTimeMillis();
        System.out.println("From Logging Aspect: before method"+proceedingJoinPoint.getSignature());
        Object o= proceedingJoinPoint.proceed();
        long t2=System.currentTimeMillis();
        System.out.println("From Logging Aspect: After method"+proceedingJoinPoint.getSignature());
        System.out.println("From Logging Aspect Duration:"+(t2-t1));

        return o;
    }

   @AfterThrowing(pointcut = "execution(* *..*(..))" ,throwing = "ex")
    public void err(Exception ex){
       System.out.println(ex.getMessage());
   }



}
