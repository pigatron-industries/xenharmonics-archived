package com.pigatron.xen.web.config;

import com.pigatron.xen.domain.entity.ApplicationState;
import com.pigatron.xen.service.ApplicationStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {

    @Autowired
    private ApplicationStateService applicationStateService;

    @Bean
    public ApplicationState applicationState() {
        return applicationStateService.load();
    }

}
