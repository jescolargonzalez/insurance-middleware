package com.tfm.aseguradora.backend.middle.controller.mapper;

import com.tfm.aseguradora.backend.middle.controller.*;
import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.generated.middle.controller.PolicyTypesControllerDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PolicyTypeDtoControllerMapper {

    PolicyTypesControllerDto domainToDto (PolicyTypeDomain policyTypeDomain);

    PolicyTypeDomain dtoToDomain (PolicyTypesControllerDto policyTypesControllerDto);


}
