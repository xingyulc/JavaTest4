package com.hand.infra.aop;



import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopRecord {

    @Pointcut("execution(* com.hand.api.service.impl.FilmServiceImpl.*(..))")
    public void recordLog(){}

    @Before("recordLog()")
    public void BeforeInsertFilmEvent() {
        this.printLog("Before Insert Film Data");
    }

    @After("recordLog()")
    public void AfterInsertFilmEvent() {
        this.printLog("After Insert Film Data");
    }

    private void printLog(String str){
        System.out.println(str);
    }
}