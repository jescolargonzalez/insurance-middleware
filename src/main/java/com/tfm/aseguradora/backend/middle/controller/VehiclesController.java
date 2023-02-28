package com.tfm.aseguradora.backend.middle.controller;

import com.tfm.aseguradora.backend.middle.controller.mapper.*;
import com.tfm.aseguradora.backend.middle.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;

import com.tfm.aseguradora.backend.middle.controller.VehicleControllerDto;

import com.tfm.aseguradora.backend.middle.controller.VehiclesApi;

import java.util.*;

@Slf4j
@RestController
public class VehiclesController implements VehiclesApi {

    @Autowired
    private VehicleDtoControllerMapper mapper;

    @Autowired
    private VehicleService vehicleService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return VehiclesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<VehicleControllerDto> createVehicle(VehicleControllerDto vehicleDto) {

        var domain = mapper.fromDtoToDomain(vehicleDto);

        domain = vehicleService.save(domain);

        vehicleDto = mapper.fromDomainToDto(domain);

        return ResponseEntity.ok(vehicleDto);
    }

    @Override
    public ResponseEntity<VehicleControllerDto> getVehicleByDni(String dniPropietario) {
        return VehiclesApi.super.getVehicleByDni(dniPropietario);
    }
}