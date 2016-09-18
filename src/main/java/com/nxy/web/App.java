package com.nxy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by xinyang on 16/8/28.
 */
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class App {
    public static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.LOG);
        ApplicationContext applicationContext = app.run(args);
        Environment ev = applicationContext.getEnvironment();
        logger.info("App version " + ev.getProperty("app.version") + " is run");
    }
}
