package com.baizhi.conf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 徐三
 * @company com.1999
 * @create 2019-12-03 16:23
 */
@Component  //交由工厂管理
@Aspect //声明当前类为一个切面
public class TestConf {

    //  切入点
    @Pointcut(value = ("execution(* com.baizhi.service.*.*(..))"))
    public void pt(){
        /*
         *   空方法
         * */
    }

    //前置通知
    @Before(value = "execution(* com.baizhi.service.*.*(..))")
    public void beafor(JoinPoint joinPoint){
        System.out.println("我是前置通知!");
    }
    /*
     * 环绕通知
     * */
    @Around("pt()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("before---------");
        Object proceed = null;
        try {
            /*
             * proceed: 目标方法的返回值
             * */
            proceed = proceedingJoinPoint.proceed();
            System.out.println(proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after---------");
        return proceed;
    }
}
