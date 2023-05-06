package org.altruistas.awsiberiacruzroja.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.altruistas.awsiberiacruzroja.models.requests.AddAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.requests.UpdateAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.responses.*;
import org.altruistas.awsiberiacruzroja.services.AcogidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/acogidas")
@Log4j2
@RequiredArgsConstructor
public class AcogidaController {
    private final AcogidaService acogidaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddAcogidaResponse> addAcogida(@RequestBody @Valid
                                                         final AddAcogidaRequest addAcogidaRequest) {
        log.info("POST api/v1/acogidas");
        return new ResponseEntity<>(acogidaService.addAcogida(addAcogidaRequest), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAcogidasResponse> getAcogidas() {
        log.info("GET api/v1/acogidas");
        return ResponseEntity.ok(acogidaService.getAcogidas());
    }

    @GetMapping(value = "/{acogida_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAcogidaResponse> getAcogida(@PathVariable("acogida_id") final String acogidaId) {
        log.info("GET api/v1/acogidas/{}", acogidaId);
        return ResponseEntity.ok(acogidaService.getAcogida(acogidaId));
    }

    @PutMapping(value = "/{acogida_id}",
                consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateAcogidaResponse> updateAcogida(@PathVariable("acogida_id") final String acogidaId,
                                                               @RequestBody @Valid
                                                               final UpdateAcogidaRequest updateAcogidaRequest) {
        log.info("PUT api/v1/acogidas/{}", acogidaId);
        return ResponseEntity.ok(acogidaService.updateAcogida(acogidaId, updateAcogidaRequest));
    }

    @DeleteMapping(value = "/{acogida_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeleteAcogidaResponse> deleteAcogida(@PathVariable("acogida_id") final String acogidaId) {
        log.info("DELETE api/v1/acogidas/{}", acogidaId);
        return ResponseEntity.ok(acogidaService.deleteAcogida(acogidaId));
    }
}
