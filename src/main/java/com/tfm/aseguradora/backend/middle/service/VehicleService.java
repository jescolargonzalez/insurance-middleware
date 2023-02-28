package com.tfm.aseguradora.backend.middle.service;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.middle.service.exception.*;
import com.tfm.aseguradora.backend.middle.service.mapper.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.tfm.aseguradora.backend.middle.users.client.VehicleApi;
import org.springframework.web.client.*;

@Slf4j
@Service
public class VehicleService {

    @Autowired
    private VehicleApi vehiclesApi;

    @Autowired
    private VehicleDtoInternalMapper mapper;

    public VehicleDomain save(VehicleDomain domain)  {
        var vehicleDto = mapper.fromDomainToDto(domain);

        try {
            var vehicleClientDto = vehiclesApi.createVehicle(vehicleDto);
            return mapper.fromDtoToDomain(vehicleClientDto);
        } catch (HttpClientErrorException ex) {
            if (ex.getRawStatusCode() == 400) {
                throw new BadRequestException(ex.getMessage());
            }
            throw ex;
        }
    }
}