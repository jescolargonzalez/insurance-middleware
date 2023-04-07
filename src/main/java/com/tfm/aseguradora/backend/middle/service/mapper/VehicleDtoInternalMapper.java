package com.tfm.aseguradora.backend.middle.service.mapper;

import com.tfm.aseguradora.backend.middle.controller.*;
import com.tfm.aseguradora.backend.middle.service.domain.*;

import org.mapstruct.*;

import com.tfm.aseguradora.backend.generated.middle.users.dto.VehicleClientDto;

@Mapper(componentModel = "spring")
public interface VehicleDtoInternalMapper {

    VehicleDomain fromDtoToDomain(VehicleClientDto dto);

    VehicleClientDto fromDomainToDto(VehicleDomain domain);

}