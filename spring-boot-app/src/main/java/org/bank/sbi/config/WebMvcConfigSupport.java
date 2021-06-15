package org.bank.sbi.config;

import org.bank.sbi.interceptor.MaintenanceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class WebMvcConfigSupport extends WebMvcConfigurationSupport {

    @Autowired
    private MaintenanceInterceptor maintenanceInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(maintenanceInterceptor).addPathPatterns("/stateCity/*");
    }
}
