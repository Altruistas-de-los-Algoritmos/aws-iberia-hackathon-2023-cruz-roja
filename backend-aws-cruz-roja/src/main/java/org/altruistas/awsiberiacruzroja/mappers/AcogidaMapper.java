package org.altruistas.awsiberiacruzroja.mappers;

import org.altruistas.awsiberiacruzroja.models.entities.AcogidaEntity;
import org.altruistas.awsiberiacruzroja.models.requests.AddAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.requests.UpdateAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.responses.AddAcogidaResponse;
import org.altruistas.awsiberiacruzroja.models.responses.GetAcogidaResponse;
import org.altruistas.awsiberiacruzroja.models.responses.UpdateAcogidaResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AcogidaMapper {
    AcogidaEntity mapAddAcogidaRequestToAcogidaEntity(AddAcogidaRequest addAcogidaRequest);

    AddAcogidaResponse mapAcogidaEntityToAddAcogidaResponse(AcogidaEntity acogidaEntity);

    GetAcogidaResponse mapAcogidaEntityToGetAcogidaResponse(AcogidaEntity acogidaEntity);

    List<GetAcogidaResponse> mapAcogidaEntityListToGetAcogidasResponse(List<AcogidaEntity> acogidaEntityList);

    AcogidaEntity mapUpdateAcogidaRequestToAcogidaEntity(UpdateAcogidaRequest updateAcogidaRequest);

    UpdateAcogidaResponse mapAcogidaEntityToUpdateAcogidaResponse(AcogidaEntity acogidaEntity);
}
