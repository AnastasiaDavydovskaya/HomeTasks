package by.tms.lesson39.ToDo.configiration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* by.tms.lesson39.ToDo.services.*Service.*(..))")
    public void services() {}

    @Around("services()")
    public void aroundServices(ProceedingJoinPoint proceedingJoinPoint) {
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
        log.info("Called method '{}.{}': data {} of starting task", className, methodName, LocalTime.now());
        log.info("Data {} of '{}.{}' method execution", LocalTime.now(), className, methodName);
    }

}
