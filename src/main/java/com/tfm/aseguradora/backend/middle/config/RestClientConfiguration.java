package com.tfm.aseguradora.backend.middle.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;


@Configuration
public class RestClientConfiguration {

    @Value("${rest.client.core.users.host}")
    private String baseUsersHost;

    @Bean
    @Primary
    public com.tfm.aseguradora.backend.middle.users.ApiClient securityClient(
            @Autowired @Qualifier("restTemplateJwtInterceptor") RestTemplate restTemplate
    ) {
        var userApiClient = new com.tfm.aseguradora.backend.middle.users.ApiClient(restTemplate);
        userApiClient.setBasePath(baseUsersHost);
        return userApiClient;
    }

    @Bean("restTemplateJwtInterceptor")
    @Primary
    public RestTemplate restTemplate() {
        var restTemplate = new RestTemplate();
        var restTemplateInterceptors = restTemplate.getInterceptors();
        restTemplateInterceptors.add(new RestClientJwtInterceptor());
        return restTemplate;
    }

    @Bean("restTemplateWithoutInterceptor")
    public RestTemplate restTemplateWithoutinterceptor() {
        return new RestTemplate();
    }

}