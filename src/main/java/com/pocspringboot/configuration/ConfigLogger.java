package com.pocspringboot.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfigLogger {

    private static final Logger logger = LoggerFactory.getLogger(ConfigLogger.class);

    @Value("${DATABASE_URL:}")
    private String databaseUrl;

    @Value("${DATABASE_USERNAME:}")
    private String databaseUsername;

    @Value("${DATABASE_PASSWORD:}")
    private String databasePassword;

    @PostConstruct
    public void logConfig() {
        logger.info("Database URL: {}", databaseUrl);
        logger.info("Database Username: {}", databaseUsername);
        logger.info("Database Password: {}", databasePassword);
    }
}
