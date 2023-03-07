package com.tfm.aseguradora.backend.middle.controller;

import com.tfm.aseguradora.backend.middle.controller.UsersApi;
import com.tfm.aseguradora.backend.middle.controller.mapper.*;
import com.tfm.aseguradora.backend.middle.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import com.tfm.aseguradora.backend.middle.controller.UserControllerDto;

import java.util.*;

@RestController
public class UsersController implements UsersApi {

    @Autowired
    UserService userService;

    @Autowired
    UserDtoControllerMapper mapper;

    @Override
    public Optional<NativeWebRequest> getRequest() { return UsersApi.super.getRequest(); }

    @Override
    public ResponseEntity<UserControllerDto> createUser(UserControllerDto userControllerDto) {
        var userDomain = mapper.fromDtoToDomain(userControllerDto);
        userDomain = userService.save(userDomain);
        var userDom = mapper.fromDomainToDto(userDomain);
        return ResponseEntity.ok(userDom);
    }

}
