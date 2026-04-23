package com.javarush.pantera.lesson04.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@EnableAspectJAutoProxy
@Component
public class AspectLog {

    @Before("com.javarush.pantera.lesson04.aop.Pointcuts.isService() || com.javarush.pantera.lesson04.aop.Pointcuts.isAnotatedRepository()")
    public void startAnyComponent(JoinPoint joinPoint) {
        String classname = joinPoint.getTarget().getClass().getName();
        Signature signature = joinPoint.getSignature();
        String argsLine = Arrays.toString(joinPoint.getArgs())
                .replace("[", "")
                .replace("]", "");
        log.info("started {}.{}({})", classname, signature.getName(), argsLine);
    }

    @After("com.javarush.pantera.lesson04.aop.Pointcuts.isService() || com.javarush.pantera.lesson04.aop.Pointcuts.isAnotatedRepository()")
    public void finishAnyComponent(JoinPoint joinPoint) {
        String classname = joinPoint.getTarget().getClass().getName();
        Signature signature = joinPoint.getSignature();
        String argsLine = Arrays.toString(joinPoint.getArgs())
                .replace("[", "")
                .replace("]", "");
        log.info("finished {}.{}({})", classname, signature.getName(), argsLine);
    }

    @Around(value = "com.javarush.pantera.lesson04.aop.Pointcuts.isMethodById() && args(id) && target(component)",
            argNames = "proceedingJoinPoint,id,component")
    public Object aroundAnyMethodById(ProceedingJoinPoint proceedingJoinPoint, Long id, Object component) throws Throwable {
        //before
        log.info("\t\tbefore {} with id={}", component, id);
        try {
            Object result = proceedingJoinPoint.proceed();
            log.info("\t\tafter return {} with id={}", component, id);
            return result;
        } catch (Throwable throwable) {
            log.info("\t\t\tafter throwing {} with id={}", component, id);
            throw throwable;
        } finally {
            log.info("\tafter all {} with id={}", component, id);

        }

    }


}
