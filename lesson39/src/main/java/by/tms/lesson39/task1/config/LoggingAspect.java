package by.tms.lesson39.task1.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* by.tms.lesson39.task1.services.*Service.*(..))")
    public void services() {}

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositories() {}

    @Around("services() || repositories()")
    public Object aroundServicesAndRepositories(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
        Object[] args = proceedingJoinPoint.getArgs();
        log.debug("Called method '{}.{}' with arguments: {}", className, methodName, args);

        try {
            result = proceedingJoinPoint.proceed();
            log.debug("Method '{}.{}' returned value: {}", className, methodName, result);
        } catch (Throwable e) {
            log.error("Error {} during method '{}.{}'", e.getMessage(), className, methodName);
        }

        return result;
    }
}
