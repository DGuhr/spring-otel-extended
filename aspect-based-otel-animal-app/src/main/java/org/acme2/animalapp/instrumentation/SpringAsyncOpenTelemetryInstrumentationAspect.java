package org.acme2.animalapp.instrumentation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringAsyncOpenTelemetryInstrumentationAspect extends AbstractSpringOpenTelemetryInterceptor {


    // change to your package
    @Pointcut("within(org.acme2.animalapp..*) && execution(@org.springframework.scheduling.annotation.Async * *.*(..))")
    static void atAsyncMethods() {
    }

}
