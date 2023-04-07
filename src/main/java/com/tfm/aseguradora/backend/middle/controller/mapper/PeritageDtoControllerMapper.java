package com.tfm.aseguradora.backend.middle.controller.mapper;

import com.tfm.aseguradora.backend.generated.middle.controller.*;
import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.generated.middle.controller.PeritageControllerDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PeritageDtoControllerMapper {

    @Mappings({
            @Mapping(source = "idPart", target = "partId"),
            @Mapping(source = "idDecission", target = "decissionId")
    })
    PeritageDomain fromDtoToDomain (PeritageControllerDto peritageControllerDto);

    @Mappings({
            @Mapping(source = "partId", target = "idPart"),
            @Mapping(source = "decissionId", target = "idDecission")
    })
    PeritageControllerDto fromDomainToDto (PeritageDomain peritageDomain);
}
