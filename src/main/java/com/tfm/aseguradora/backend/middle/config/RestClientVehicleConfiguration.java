package com.tfm.aseguradora.backend.middle.config;

import com.tfm.aseguradora.backend.generated.middle.users.client.VehicleApi;

import com.tfm.aseguradora.backend.generated.middle.users.ApiClient;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class RestClientVehicleConfiguration {

    @Value("${rest.client.core.users.host}")
    private String baseUsersHost;


    @Bean("vehicleApi")
    public VehicleApi vehicleApi(@Autowired @Qualifier("usersApiClient") ApiClient apiClient) {
        VehicleApi vehicleApi = new VehicleApi();
        vehicleApi.setApiClient(apiClient);
        return vehicleApi;
    }


}