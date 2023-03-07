package com.tfm.aseguradora.backend.middle.service;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.middle.service.exception.*;
import com.tfm.aseguradora.backend.middle.service.mapper.*;
import org.springframework.beans.factory.annotation.*;
import com.tfm.aseguradora.backend.middle.users.client.UserApi;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import com.tfm.aseguradora.backend.middle.users.dto.RolClientDto;

import java.util.*;
import java.util.stream.*;

@Service
public class UserService {
    @Autowired
    private UserApi userapi;

    @Autowired
    private UserDtoInternalMapper mapper;


    public UserDomain findById(int id) {
         var aux =  userapi.getUserById(String.valueOf(id));
         if(aux != null){
             return mapper.fromDtoToDomain(aux);
         }else{
             throw new ResourceNotFoundException(UserDomain.class, id);
         }
    }

    public UserDomain save(UserDomain userDomain) {
        var dto = mapper.fromDomainToDto(userDomain);
        var roles = new ArrayList<>(dto.getRoles());
        //cliente
        dto.setRoles(roles);
        try {
            var client = userapi.createUser(dto);
            return mapper.fromDtoToDomain(client);
        } catch (HttpClientErrorException ex) {
            if (ex.getRawStatusCode() == 400) {
                throw new BadRequestException(ex.getMessage());
            }
            throw ex;
        }
    }
}
