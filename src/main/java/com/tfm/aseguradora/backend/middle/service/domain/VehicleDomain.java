package com.tfm.aseguradora.backend.middle.service.domain;


import lombok.*;

import java.time.*;

@Data
public class VehicleDomain {

    private Long id;

    private String marca;

    private String modelo;

    private LocalDate fechaMatriculacion;

    private String matricula;

    private Integer kilometros;

    private Integer userId;

}