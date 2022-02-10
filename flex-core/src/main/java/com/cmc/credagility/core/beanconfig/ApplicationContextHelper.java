package com.cmc.credagility.core.beanconfig;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by xma on 10/17/2017.
 */
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext context = null;

    //~ ------------------------------------------------------------------------------------------------------------------

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        context = appContext;
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /*
        usage: e.g., ApplicationContextHelper.<EvalManager>getBean("evalManager");
     */
    public static <T extends Object> T getBean (String beanName) {
        if (context != null) {
            return (T)context.getBean(beanName);
        }
        return null;
    }

}
