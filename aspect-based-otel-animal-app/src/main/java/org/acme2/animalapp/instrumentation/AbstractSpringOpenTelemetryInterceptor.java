package org.acme2.animalapp.instrumentation;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AbstractSpringOpenTelemetryInterceptor {

    private final String INSTRUMENTATION_APP_PACKAGE = "org.acme2.animalapp";
    private final Tracer tracer = GlobalOpenTelemetry.getTracer(INSTRUMENTATION_APP_PACKAGE);

    protected Object wrapWithSpan(ProceedingJoinPoint pjp) throws Throwable {

        Span span = tracer.spanBuilder(generateSubsegmentName(pjp)).startSpan();
        try (Scope ignored = span.makeCurrent()) {
            return conditionalProceed(pjp);
        } finally {
            span.end();
        }
    }

    protected String generateSubsegmentName(ProceedingJoinPoint pjp) {
        return pjp.getSignature().getDeclaringType().getSimpleName() + "." + pjp.getSignature().getName();
    }

    private static Object conditionalProceed(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.getArgs().length == 0 ? pjp.proceed() : pjp.proceed(pjp.getArgs());
    }
}
