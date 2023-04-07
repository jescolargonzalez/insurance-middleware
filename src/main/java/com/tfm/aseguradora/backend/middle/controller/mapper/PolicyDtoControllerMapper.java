package com.tfm.aseguradora.backend.middle.controller.mapper;

import com.tfm.aseguradora.backend.middle.controller.*;
import com.tfm.aseguradora.backend.generated.middle.controller.PolicyTypesControllerDto;
import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.generated.middle.controller.PolicyControllerDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PolicyDtoControllerMapper {

    PolicyControllerDto domainToDto(PolicyDomain policyDomain);

    PolicyDomain dtoToDomain (PolicyControllerDto policyControllerDto);




}
