package com.tfm.aseguradora.backend.middle.config;


import com.tfm.aseguradora.backend.generated.middle.users.ApiClient;
import com.tfm.aseguradora.backend.generated.middle.users.client.UserApi;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class RestClientUserConfiguration {

    @Value("${rest.client.core.users.host}")
    private String baseUsersHost;


    @Bean
    public ApiClient usersApiClient(
            @Autowired @Qualifier("restTemplateJwtInterceptor") RestTemplate restTemplate
    ) {
        var userApiClient = new com.tfm.aseguradora.backend.generated.middle.users.ApiClient(restTemplate);
        userApiClient.setBasePath(baseUsersHost);
        return userApiClient;
    }

    @Bean("userApi")
    public UserApi userApi(@Autowired @Qualifier("usersApiClient") ApiClient apiClient) {
        UserApi userApi = new UserApi();
        userApi.setApiClient(apiClient);
        return userApi;
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