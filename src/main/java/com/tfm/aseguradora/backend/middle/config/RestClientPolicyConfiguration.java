package com.tfm.aseguradora.backend.middle.config;


import com.tfm.aseguradora.backend.generated.middle.policies.ApiClient;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

import com.tfm.aseguradora.backend.generated.middle.policies.client.PolicyApi;

@Configuration
public class RestClientPolicyConfiguration {

    @Value("${rest.client.core.policies.host}")
    private String basePoliciesHost;

    @Bean
    public ApiClient policiesApiClient(
            @Autowired @Qualifier("restTemplateJwtInterceptor") RestTemplate restTemplate
    ) {
        var userApiClient = new com.tfm.aseguradora.backend.generated.middle.policies.ApiClient(restTemplate);
        userApiClient.setBasePath(basePoliciesHost);
        return userApiClient;
    }

    @Bean("policyApi")
    public PolicyApi policyApi(@Autowired @Qualifier("policiesApiClient") ApiClient apiClient) {
        PolicyApi policyApi = new PolicyApi();
        policyApi.setApiClient(apiClient);
        return policyApi;
    }



}