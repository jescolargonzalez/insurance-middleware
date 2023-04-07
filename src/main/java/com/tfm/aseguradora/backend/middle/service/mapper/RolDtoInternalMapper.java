package com.tfm.aseguradora.backend.middle.service.mapper;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import org.mapstruct.*;
import com.tfm.aseguradora.backend.generated.middle.users.dto.RolClientDto;

@Mapper(componentModel = "spring")
public interface RolDtoInternalMapper {


    RolDomain fromDtoToDomain (RolClientDto rolClientDto);

}
