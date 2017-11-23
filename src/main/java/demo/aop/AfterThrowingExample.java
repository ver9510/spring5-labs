package demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingExample {

    @AfterThrowing(
            pointcut = "demo.aop.SystemArchitecture.dataAccessOperation()",
            throwing = "ex")
    public void doRecoveryActions(Exception ex) {
        // ...
    }

    @Around("demo.aop.SystemArchitecture.inServiceLayer()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
}