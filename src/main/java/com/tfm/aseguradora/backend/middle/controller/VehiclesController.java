package com.tfm.aseguradora.backend.middle.controller;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;

import java.util.*;

@Slf4j
@RestController
public class VehiclesController implements VehiclesApi {

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return VehiclesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<VehicleDto> createVehicle(VehicleDto vehicleDto) {
        return VehiclesApi.super.createVehicle(vehicleDto);
    }

    @Override
    public ResponseEntity<VehicleDto> getVehicleByDni(String dniPropietario) {
        return VehiclesApi.super.getVehicleByDni(dniPropietario);
    }
}