package org.retail.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static org.retail.order.util.Util.getHttpComponentsClientHttpRequestFactory;

@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate(getHttpComponentsClientHttpRequestFactory());
    }
}
