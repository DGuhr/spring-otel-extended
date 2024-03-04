package org.acme4.animalapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppStartupListener implements ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(AppStartupListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("\uD83D\uDE80 Application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("\uD83D\uDED1 Application stopped");
    }

}
