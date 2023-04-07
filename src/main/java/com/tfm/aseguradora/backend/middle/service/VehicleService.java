package com.tfm.aseguradora.backend.middle.service;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.middle.service.exception.*;
import com.tfm.aseguradora.backend.middle.service.mapper.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;


import org.springframework.web.client.*;

import com.tfm.aseguradora.backend.generated.middle.users.client.VehicleApi;

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
    public VehicleDomain findById(Integer id) {
        var vehicle = vehiclesApi.getVehiclesById(id);
        if (vehicle != null) {
            return mapper.fromDtoToDomain(vehicle);
        }
        else {
            throw new ResourceNotFoundException(VehicleDomain.class, id);
        }
    }

    //return list findbydni
    public VehicleDomain findByDni(String dniPropietario){

        var finded = vehiclesApi.getVehiclesByDni(dniPropietario);

        return null;

    }


}