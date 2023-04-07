package com.tfm.aseguradora.backend.middle.controller;

import com.tfm.aseguradora.backend.generated.middle.controller.*;
import com.tfm.aseguradora.backend.middle.controller.mapper.*;
import com.tfm.aseguradora.backend.middle.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;

import java.util.*;
@RestController
public class PoliciesController implements PolizyesApi {

    @Autowired
    private PoliciesService policiesService;
    @Autowired
    private PolicyDtoControllerMapper mapperPolicy;

    @Override
    public Optional<NativeWebRequest> getRequest() { return PolizyesApi.super.getRequest();    }

    //No Funciona
    @Override
    public ResponseEntity<PolicyControllerDto> createPolicy(PolicyControllerDto policyControllerDto) {
        var policyDom = mapperPolicy.dtoToDomain(policyControllerDto);
        policiesService.savePolicy(policyDom);
        var policyDto = mapperPolicy.domainToDto(policyDom);
        return ResponseEntity.ok().body(policyDto);
    }

    @Override
    public ResponseEntity<PolicyControllerDto> getPolicyByDni(String tomadorDni, String benefitDni) {
        return PolizyesApi.super.getPolicyByDni(tomadorDni, benefitDni);
    }

    @Override
    public ResponseEntity<List<PolicyTypesControllerDto>> findTypesOfPolicy() {
        return PolizyesApi.super.findTypesOfPolicy();
    }

    @Override
    public ResponseEntity<PolicyControllerDto> savePart(String idPoliza, PartControllerDto partControllerDto) {
        return PolizyesApi.super.savePart(idPoliza, partControllerDto);
    }
    @Override
    public ResponseEntity<List<PeritageControllerDto>> doPeritageAction(String idPolicy, String idPart, PeritageControllerDto peritageControllerDto) {
        return PolizyesApi.super.doPeritageAction(idPolicy, idPart, peritageControllerDto);
    }

}