package com.tfm.aseguradora.backend.middle.controller;

import com.tfm.aseguradora.backend.middle.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class PartsController implements com.tfm.aseguradora.backend.middle.controller.PartsApi {

    @Autowired
    private PartService partService;



}
