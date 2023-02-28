package com.tfm.aseguradora.backend.middle.service.mapper;

import com.tfm.aseguradora.backend.middle.controller.*;
import com.tfm.aseguradora.backend.middle.service.domain.*;

import com.tfm.aseguradora.backend.middle.users.dto.VehicleClientDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VehicleDtoInternalMapper {

    VehicleDomain fromDtoToDomain(VehicleClientDto dto);

    VehicleClientDto fromDomainToDto(VehicleDomain domain);

}