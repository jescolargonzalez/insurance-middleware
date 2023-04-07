package com.tfm.aseguradora.backend.middle.service.mapper;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.generated.middle.policies.client.dto.PolicyClientDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PolicyDtoInternalMapper {

    PolicyDomain DtoToDomain(PolicyClientDto policyClientDto);

    PolicyClientDto DomainToDto(PolicyDomain policyDomain);

}
