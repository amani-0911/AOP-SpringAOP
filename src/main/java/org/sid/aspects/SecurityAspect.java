package org.sid.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class SecurityAspect {
    @Around(value="@annotation(securedByAspect)",argNames = "proceedingJoinPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint,SecuredByAspect securedByAspect) throws Throwable {
        System.out.println("*******************Security**********************");
     String[] roles= securedByAspect.roles();
     boolean authorised=false;

        for (String r:roles) {
            if(SecurityContext.hasRole(r))
                authorised=true;
            break;
        }
        if (authorised) {
            Object resu=proceedingJoinPoint.proceed();
            return resu;
        }
    throw new RuntimeException("Not Authorized");

    }
}
