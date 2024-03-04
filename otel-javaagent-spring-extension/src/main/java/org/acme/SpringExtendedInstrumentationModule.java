/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.acme;


import com.google.auto.service.AutoService;
import io.opentelemetry.javaagent.extension.instrumentation.InstrumentationModule;
import io.opentelemetry.javaagent.extension.instrumentation.TypeInstrumentation;

import java.util.List;
import java.util.logging.Logger;

import static java.util.Collections.singletonList;

@AutoService(InstrumentationModule.class)
public final class SpringExtendedInstrumentationModule extends InstrumentationModule {
    private static Logger logger = Logger.getLogger(SpringExtendedInstrumentationModule.class.getName());

    public SpringExtendedInstrumentationModule() {
        super("spring-extended", "springextended");
        logger.info("Adding spring-extension");
    }

    @Override
    public int order() {
        return 1;
    }

    @Override
    public List<String> getAdditionalHelperClassNames() {
        return List.of(SpringExtendedInstrumentation.class.getName(),"io.opentelemetry.javaagent.extension.instrumentation.TypeInstrumentation");
    }

    @Override
    public List<TypeInstrumentation> typeInstrumentations() {
        return singletonList(new SpringExtendedInstrumentation());
    }
}