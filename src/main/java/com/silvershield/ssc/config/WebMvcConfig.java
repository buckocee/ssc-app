package com.silvershield.ssc.config;

import com.silvershield.ssc.auth.RequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private RequestInterceptor requestInterceptor;

    @Autowired
    public WebMvcConfig(RequestInterceptor requestInterceptor){
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(requestInterceptor);
        _logger.info("Added custom request interceptor with authentication ");
    }
}
