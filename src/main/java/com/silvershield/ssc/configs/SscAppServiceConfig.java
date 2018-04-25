package com.silvershield.ssc.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SscAppServiceConfig {

    @Value("${signing.key}")
    private String jwtSigningKey="";


    public String getJwtSigningKey() {
        return jwtSigningKey;
    }


}
