package org.acme2.animalapp.instrumentation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringServiceOpenTelemetryInstrumentationAspect extends AbstractSpringOpenTelemetryInterceptor {

    @Around("publicMethodOfService() && " +
            "!org.acme2.animalapp.instrumentation.SpringAsyncOpenTelemetryInstrumentationAspect.atAsyncMethods() && " +
            "!org.acme2.animalapp.instrumentation.SpringScheduledOpenTelemetryInstrumentationAspect.atScheduledMethods()")
    public Object traceAroundServiceMethods(ProceedingJoinPoint pjp) throws Throwable {
        return wrapWithSpan(pjp);
    }

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    static void beanAnnotatedWithService() {
    }

    @Pointcut("beanAnnotatedWithService() && publicMethod()")
    static void publicMethodOfService() {
    }

    @Pointcut("within(org.acme2.animalapp..*) && execution(public * *(..))")
    static void publicMethod() {
    }

}
