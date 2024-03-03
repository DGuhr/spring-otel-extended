package org.acme2.animalapp.instrumentation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringRepositoryOpenTelemetryInstrumentationAspect extends AbstractSpringOpenTelemetryInterceptor {

    @Around("publicMethodOfRepository() &&" +
            "!org.acme2.animalapp.instrumentation.SpringAsyncOpenTelemetryInstrumentationAspect.atAsyncMethods() && " +
            "!org.acme2.animalapp.instrumentation.SpringScheduledOpenTelemetryInstrumentationAspect.atScheduledMethods()")
    public Object traceAroundRepositoryMethods(ProceedingJoinPoint pjp) throws Throwable {
        return this.wrapWithSpan(pjp);
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    static void beanAnnotatedWithRepository() {
    }

    @Pointcut("beanAnnotatedWithRepository() && publicMethod()")
    static void publicMethodOfRepository() {
    }

    @Pointcut("within(org.acme2.animalapp..*) && execution(public * *(..))")
    static void publicMethod() {

    }

}
