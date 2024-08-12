package com.roboelectric.shopslisting;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.roboelectric.shopslisting.service.*.*(..)) || execution(* com.roboelectric.shopslisting.controller.*.*(..))")
    public void methodExecutionTimeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        log.error("[HARMLESS]Before method Execution of method "+joinPoint.getSignature());
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.error("[HARMLESS]After method Execution of method "+joinPoint.getSignature() +" method take milisec ->"+(endTime-startTime));
    }

    @AfterThrowing(pointcut = "execution(* com.roboelectric.shopslisting..*.*(..))", throwing = "ex")
    public void handleExceptions(Exception ex) {
        logErrorBasedOnExceptionType(ex);
    }

    private void logErrorBasedOnExceptionType(Exception e) {
        if (e instanceof IOException) {
            log.error("IOException occurred: {}", e.getMessage());
        } else if (e instanceof SQLException) {
            log.error("SQLException occurred: {}", e.getMessage());
        } else {
            log.error("Exception occurred: {}", e.getMessage());
        }
    }




}
