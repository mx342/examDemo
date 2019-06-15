package com.tianyou.exam;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppHolder implements ApplicationContextAware {


    private static ApplicationContext app;


    public static AppConfig conf() {
        return app.getBean(AppConfig.class);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        app = applicationContext;
    }
}
