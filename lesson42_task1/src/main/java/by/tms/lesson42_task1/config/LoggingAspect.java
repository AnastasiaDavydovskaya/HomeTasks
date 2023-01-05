package by.tms.lesson42_task1.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* by.tms.lesson42_task1.services.*ServiceImpl.*(..))")
    public void services() {}

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositories() {}

    @Around("services() || repositories()")
    public Object aroundServicesAndRepositories(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
        Object[] args = proceedingJoinPoint.getArgs();
        log.debug("Called service method '{}.{}' with arguments: {}", className, methodName, args);
        try {
            result = proceedingJoinPoint.proceed();
            log.debug("Method '{}.{}' returned value: {}", className, methodName, result);
        } catch (Throwable e) {
            log.error("Error {} during service method '{}.{}' call", e.getMessage(), className, methodName);
            throw e;
        }

        return result;
    }

    @Pointcut("execution(* by.tms.lesson42_task1.services.*ServiceImpl.create(..))")
    public void serviceCreate() {}

    @Before("serviceCreate()")
    public void beforeServiceCreate(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        boolean result = Arrays.stream(args)
                .anyMatch(Objects::isNull);

        if(result) {
            log.debug("Found empty argument");
        }
    }
}
