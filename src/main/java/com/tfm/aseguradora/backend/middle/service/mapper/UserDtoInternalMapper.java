package com.tfm.aseguradora.backend.middle.service.mapper;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import org.mapstruct.*;
import com.tfm.aseguradora.backend.generated.middle.users.dto.UserClientDto;

@Mapper(componentModel = "spring")
public interface UserDtoInternalMapper {
    @Mappings({
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "surName", target = "apellidos"),
            @Mapping(source = "email", target = "mail"),
            @Mapping(source = "birthday", target = "birthdate"),
            @Mapping(source = "password", target = "pass"),
    })
    UserDomain fromDtoToDomain(UserClientDto dto);

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "surName"),
            @Mapping(source = "mail",target = "email"),
            @Mapping(source = "birthdate",target = "birthday"),
            @Mapping(source = "pass",target = "password")
    })
    UserClientDto fromDomainToDto(UserDomain userDomain);

}
