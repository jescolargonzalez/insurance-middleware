package com.tfm.aseguradora.backend.middle.service;
import com.tfm.aseguradora.backend.generated.middle.policies.client.PolicyApi;
import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.middle.service.exception.*;
import com.tfm.aseguradora.backend.middle.service.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.tfm.aseguradora.backend.generated.middle.users.client.UserApi;
import org.springframework.web.client.*;

import java.util.*;

@Service
public class PoliciesService {
    @Autowired
    private PolicyApi policyApi;


    @Autowired
    private UserApi userapi;
    @Autowired
    private UserDtoInternalMapper mapperUser;
    @Autowired
    private PolicyDtoInternalMapper mapperPolicy;
    @Autowired
    private PartDtoInternalMapper mapperPart;

    public PolicyDomain savePolicy(PolicyDomain policyDomain){
        var aux = mapperPolicy.DomainToDto(policyDomain);
        try{
            var x = policyApi.createPolicy(aux);
            return mapperPolicy.DtoToDomain(aux);
        }catch (HttpClientErrorException ex){
            if (ex.getRawStatusCode() == 400) {
                throw new BadRequestException(ex.getMessage());
            }
            throw ex;
        }
    }

    public List<PolicyDomain> findByDni(String dni){
        return null;
    }

    public PolicyTypeDomain findAllTypesOfPolicy(){

        return null;
    }

    public PartDomain savePart(PartDomain partDomain){
        var aux = "";

        return null;
    }

}
