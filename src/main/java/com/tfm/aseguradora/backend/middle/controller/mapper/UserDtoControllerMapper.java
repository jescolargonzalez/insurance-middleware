package com.tfm.aseguradora.backend.middle.controller.mapper;

import com.tfm.aseguradora.backend.middle.controller.*;
import com.tfm.aseguradora.backend.middle.service.domain.*;
import org.mapstruct.*;
import com.tfm.aseguradora.backend.middle.controller.UserControllerDto;

@Mapper(componentModel = "spring")
public interface UserDtoControllerMapper {

    @Mappings({
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "surName", target = "apellidos"),
            @Mapping(source = "email", target = "mail"),
            @Mapping(source = "birthday", target = "birthdate"),
            @Mapping(source = "password", target = "pass"),
    })
    UserDomain fromDtoToDomain(UserControllerDto dto);

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "surName"),
            @Mapping(source = "mail",target = "email"),
            @Mapping(source = "birthdate",target = "birthday"),
            @Mapping(source = "pass",target = "password")
    })
    UserControllerDto fromDomainToDto(UserDomain domain);

}
