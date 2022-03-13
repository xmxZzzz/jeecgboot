package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Package: com.example.aspect
 * @ClassName: ServiceLogAspect
 * @Author: guoyy
 * @Description: 根据Service执行的时间使用不同级别的日志打印
 * @Date: 2022/3/13 下午10:16
 * @Version: 1.0
 */
@Aspect
@Component
public class ServiceLogAspect {

    public static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * AOP通知
     * 1.前置通知：在方法调用之前执行
     * 2.后置通知：在方法正常调用之后执行
     * 3.环绕通知：在方法调用之前和之后，都分别可以执行的通知
     * 4.异常通知：如果在方法调用过程中发生异常则通知
     * 5.最终通知：在方法调用之后执行
     * <p>
     * 切面表达式:
     * execution:代表所要执行的表达式主体
     * *: 代表方法返回类型,*表示所有类型
     * com.example.service.impl:包名代表aop监控的类所在的包
     * ..: 代表该包以及其子包下的所有类方法
     * *: 代表类名,*表示所有类
     * *(..)):.*表示类中的所有方法名,(..)表示方法中的任意参数
     */
    @Around("execution(* com.example.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("====== 开始执行 {}.{} ======",
                proceedingJoinPoint.getTarget().getClass(),
                proceedingJoinPoint.getSignature().getName());

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long takeTime = end - start;

        if (takeTime > 3000) {
            logger.error("====== 执行结束,耗时:{}毫秒 ======", takeTime);
        } else if (takeTime > 2000) {
            logger.warn("====== 执行结束,耗时:{}毫秒 ======", takeTime);
        } else {
            logger.info("====== 执行结束,耗时:{}毫秒 ======", takeTime);
        }

        return result;
    }
}
