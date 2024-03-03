package org.acme2.animalapp.instrumentation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringScheduledOpenTelemetryInstrumentationAspect extends AbstractSpringOpenTelemetryInterceptor {

    @Pointcut("within(org.acme2.animalapp..*) && execution(@org.springframework.scheduling.annotation.Scheduled * *.*(..))")
    public static void atScheduledMethods() {
    }

}
