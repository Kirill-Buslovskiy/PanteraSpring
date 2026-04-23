package com.javarush.pantera.lesson04.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Pointcuts {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void isAnotatedService(){}

    @Pointcut("within(com.javarush..*Service)")
    public void isServiceByClassSuffix(){}

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void isAnotatedRepository(){}

    @Pointcut("isAnotatedService() || isServiceByClassSuffix()")
    public void isService(){}

    @Pointcut("execution(* com.javarush..*.*Id(java.lang.Long))")
    public void isMethodById(){}

}
