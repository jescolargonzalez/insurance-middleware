package com.tfm.aseguradora.backend.middle.service.domain;


import lombok.*;

import java.util.*;

@Getter
@Setter
public class UserDomain {

    private Integer id;

    private String dni;

    private String nombre;

    private String apellidos;

    private String mail;

    private String pass;

    private String address;

    private String iban;

    private String phone;

    private String birthdate;

    private String pais;

    private String ciudad;

    private byte[] picture;

    private List<RolDomain> roles;

    private List<VehicleDomain> vehicles;

}