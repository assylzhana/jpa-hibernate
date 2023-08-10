package com.bitlab.thymeleaflayoutdialect.config;

import com.bitlab.thymeleaflayoutdialect.services.ApplicationRequestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBUtil {

    @Bean
    public ApplicationRequestService applicationRequestService(){
        return new ApplicationRequestService();
    }
}