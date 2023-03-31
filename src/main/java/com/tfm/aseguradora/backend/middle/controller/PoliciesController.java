package com.tfm.aseguradora.backend.middle.controller;

import com.tfm.aseguradora.backend.middle.controller.PolizyesApi;
import com.tfm.aseguradora.backend.middle.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.context.request.*;

import java.util.*;

public class PoliciesController implements PolizyesApi {

    @Autowired
    private PoliciesService policiesService;


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PolizyesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<com.tfm.aseguradora.backend.middle.controller.PolicyControllerDto> createPolicy(com.tfm.aseguradora.backend.middle.controller.PolicyControllerDto policyControllerDto) {
        return PolizyesApi.super.createPolicy(policyControllerDto);
    }


    @Override
    public ResponseEntity<List<com.tfm.aseguradora.backend.middle.controller.PeritageControllerDto>> doPeritageAction(String idPolicy, String idPart, com.tfm.aseguradora.backend.middle.controller.PeritageControllerDto peritageControllerDto) {
        return PolizyesApi.super.doPeritageAction(idPolicy, idPart, peritageControllerDto);
    }

    @Override
    public ResponseEntity<List<com.tfm.aseguradora.backend.middle.controller.PolicyTypesControllerDto>> findTypesOfPolicy() {
        return PolizyesApi.super.findTypesOfPolicy();
    }

    @Override
    public ResponseEntity<com.tfm.aseguradora.backend.middle.controller.PolicyControllerDto> getPolicyByDni(String tomadorDni, String benefitDni) {
        return PolizyesApi.super.getPolicyByDni(tomadorDni, benefitDni);
    }

    @Override
    public ResponseEntity<com.tfm.aseguradora.backend.middle.controller.PolicyControllerDto> savePart(String idPoliza, com.tfm.aseguradora.backend.middle.controller.PartControllerDto partControllerDto) {
        return PolizyesApi.super.savePart(idPoliza, partControllerDto);
    }
}
