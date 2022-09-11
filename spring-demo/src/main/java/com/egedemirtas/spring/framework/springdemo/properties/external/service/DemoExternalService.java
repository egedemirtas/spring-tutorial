package com.egedemirtas.spring.framework.springdemo.properties.external.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoExternalService {
    // get from properties file: external.service.url
    @Value("${external.service.url}")
    private String url;

    public String getUrl() {
        return url;
    }
}
