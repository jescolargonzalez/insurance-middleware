package com.tfm.aseguradora.backend.middle.controller;

import com.tfm.aseguradora.backend.middle.controller.UsersApi;
import com.tfm.aseguradora.backend.middle.controller.mapper.*;
import com.tfm.aseguradora.backend.middle.service.*;
import io.swagger.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import com.tfm.aseguradora.backend.middle.controller.UserControllerDto;
import com.tfm.aseguradora.backend.middle.controller.PartControllerDto;
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
        var userDto = mapper.fromDomainToDto(userDomain);
        return ResponseEntity.ok().body(userDto);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        userService.deleteById(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }
    @Override
    public ResponseEntity<UserControllerDto> getUserById(String id) {
        var dom = userService.findById(id);
        var dto = mapper.fromDomainToDto(dom);
        return ResponseEntity.ok().body(dto);
    }
    @Override
    public ResponseEntity<Void> updateUser(String id, UserControllerDto userControllerDto) {
        var user = userService.findById(id);
        var x = mapper.fromDtoToDomain(userControllerDto);
        userService.updateUserById(user.getId(),x);
        // contraseña cifrar | imagenes
        return ResponseEntity.ok().build();
    }

    //falta por terminar mover a parts
    @Override
    public ResponseEntity<PartControllerDto> getPartsByDni(String benefitDni) {
        var list = "";
        return null;
    }



}
