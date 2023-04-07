package com.tfm.aseguradora.backend.middle.service;

import com.tfm.aseguradora.backend.middle.service.domain.*;
import com.tfm.aseguradora.backend.middle.service.exception.*;
import com.tfm.aseguradora.backend.middle.service.mapper.*;
import org.springframework.beans.factory.annotation.*;
import com.tfm.aseguradora.backend.generated.middle.users.client.UserApi;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;
import java.util.stream.*;

@Service
public class UserService {
    @Autowired
    private UserApi userapi;
    @Autowired
    private UserDtoInternalMapper mapper;

    public UserDomain findById(String id) {
         var aux =  userapi.getUserById(id);
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
    public void deleteById(int id) {
        try{
            userapi.deleteUser(String.valueOf(id));
        }catch (HttpClientErrorException ex){
            if (ex.getRawStatusCode() == 400) {
                throw new BadRequestException(ex.getMessage());
            }
            throw ex;
        }
    }
    public void updateUserById(Integer id , UserDomain userDomain){
        var user = userapi.getUserById(String.valueOf(id));
        var userDto = mapper.fromDomainToDto(userDomain);
        if (user != null){
            userapi.updateUser(String.valueOf(id),userDto);
        }
    }

    public UserDomain findByMail(String mail){
        var user = userapi.getUsers(null,null,mail,null);
        var userDom = mapper.fromDtoToDomain(user.getUsers().get(0));
        return userDom;
    };

    public UserDomain findByDni(String dni){
        var user = userapi.getUsers(null,dni,null,null);
        var userDom = mapper.fromDtoToDomain(user.getUsers().get(0));
        return userDom;
    };

    public List<UserDomain> findAll(){
        var aux = userapi.getUsers(null,null,null,null);
        var list = aux.getUsers().stream().map(mapper::fromDtoToDomain).collect(Collectors.toList());
        return list;
    }

}
