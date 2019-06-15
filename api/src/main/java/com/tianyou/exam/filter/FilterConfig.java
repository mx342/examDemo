package com.tianyou.exam.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

public class FilterConfig {

    public FilterRegistrationBean second() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new GateWayFilter());
        registration.addUrlPatterns("/*");
        registration.setName("GateWayFilter");
        registration.setOrder(1);

        return registration;
    }

}
