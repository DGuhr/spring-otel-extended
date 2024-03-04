package org.acme4.animalapp;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        //same as: <mvc:annotation-driven />
        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();

        //register config class. also possible - set package to check for config classes. context.setConfigLocation("com.example.app.config");
        rootCtx.register(AppConfig.class);

        //same as: <context:component-scan base-package="..." />
        rootCtx.scan("org.acme4");
        container.addListener(new ContextLoaderListener(rootCtx));
        container.addListener(new AppStartupListener());
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("animalmvc", new DispatcherServlet(rootCtx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}