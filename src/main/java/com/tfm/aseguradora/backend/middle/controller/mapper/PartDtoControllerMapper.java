package com.tfm.aseguradora.backend.middle.controller.mapper;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.generated.middle.controller.PartControllerDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PartDtoControllerMapper {

    PartControllerDto DomainToDto(PartDomain partDomain);

    PartDomain DtoToDomain(PartControllerDto partControllerDto);


}
