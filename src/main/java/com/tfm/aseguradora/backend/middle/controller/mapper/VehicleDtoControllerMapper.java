package com.tfm.aseguradora.backend.middle.controller.mapper;


import com.tfm.aseguradora.backend.generated.middle.controller.VehicleControllerDto;
import com.tfm.aseguradora.backend.middle.service.domain.*;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface VehicleDtoControllerMapper {

    VehicleDomain fromDtoToDomain(VehicleControllerDto dto);

    VehicleControllerDto fromDomainToDto(VehicleDomain domain);

}