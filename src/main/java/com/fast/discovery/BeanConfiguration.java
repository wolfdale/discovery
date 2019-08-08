package com.fast.discovery;

import com.fast.discovery.core.DiscoveryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DiscoveryHandler getDiscoveryHandler(){
        return new DiscoveryHandler();
    }
}
