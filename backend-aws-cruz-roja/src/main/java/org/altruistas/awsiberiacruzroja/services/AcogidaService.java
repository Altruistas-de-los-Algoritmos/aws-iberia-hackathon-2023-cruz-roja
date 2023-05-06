package org.altruistas.awsiberiacruzroja.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.altruistas.awsiberiacruzroja.exceptions.AcogidaNotFoundException;
import org.altruistas.awsiberiacruzroja.mappers.AcogidaMapper;
import org.altruistas.awsiberiacruzroja.models.entities.AcogidaEntity;
import org.altruistas.awsiberiacruzroja.models.requests.AddAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.requests.UpdateAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.responses.*;
import org.altruistas.awsiberiacruzroja.repositories.AcogidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AcogidaService {
    private final AcogidaRepository acogidaRepository;
    private final AcogidaMapper acogidaMapper;

    public AddAcogidaResponse addAcogida(final AddAcogidaRequest addAcogidaRequest) {
        final AcogidaEntity acogidaEntity = acogidaMapper.mapAddAcogidaRequestToAcogidaEntity(addAcogidaRequest);
        final AcogidaEntity acogidaEntitySaved = acogidaRepository.save(acogidaEntity);
        return acogidaMapper.mapAcogidaEntityToAddAcogidaResponse(acogidaEntitySaved);
    }

    public GetAcogidasResponse getAcogidas() {
        final List<AcogidaEntity> acogidaEntityList = acogidaRepository.findAll();
        return GetAcogidasResponse.builder()
                .getAcogidaResponses(acogidaMapper.mapAcogidaEntityListToGetAcogidasResponse(acogidaEntityList))
                .build();
    }

    public GetAcogidaResponse getAcogida(final String acogidaId) {
        final AcogidaEntity acogidaEntity = acogidaRepository.findById(acogidaId)
                .orElseThrow(() -> new AcogidaNotFoundException(String.format("Acogida with id %s not found", acogidaId)));
        return acogidaMapper.mapAcogidaEntityToGetAcogidaResponse(acogidaEntity);
    }

    public UpdateAcogidaResponse updateAcogida(final String acogidaId, final UpdateAcogidaRequest updateAcogidaRequest) {
        final AcogidaEntity acogidaEntityToUpdate = acogidaMapper.mapUpdateAcogidaRequestToAcogidaEntity(updateAcogidaRequest);
        acogidaEntityToUpdate.setAcogidaId(acogidaId);
        final AcogidaEntity acogidaEntitySaved = acogidaRepository.save(acogidaEntityToUpdate);
        return acogidaMapper.mapAcogidaEntityToUpdateAcogidaResponse(acogidaEntitySaved);
    }

    public DeleteAcogidaResponse deleteAcogida(final String acogidaId) {
        acogidaRepository.deleteById(acogidaId);
        return DeleteAcogidaResponse.builder().build();
    }
}
