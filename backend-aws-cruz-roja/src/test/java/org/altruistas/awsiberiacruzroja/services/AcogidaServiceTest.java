package org.altruistas.awsiberiacruzroja.services;

import org.altruistas.awsiberiacruzroja.mappers.AcogidaMapper;
import org.altruistas.awsiberiacruzroja.models.entities.AcogidaEntity;
import org.altruistas.awsiberiacruzroja.models.requests.AddAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.requests.UpdateAcogidaRequest;
import org.altruistas.awsiberiacruzroja.models.responses.*;
import org.altruistas.awsiberiacruzroja.repositories.AcogidaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AcogidaServiceTest {
    @Mock
    private AcogidaRepository acogidaRepository;
    @Mock
    private AcogidaMapper acogidaMapper;

    @InjectMocks
    private AcogidaService acogidaService;

    @Test
    void testAddAcogida() {
        // Given
        final AddAcogidaRequest request = AddAcogidaRequest.builder().build();
        final AcogidaEntity entity = AcogidaEntity.builder().build();
        final AddAcogidaResponse response = AddAcogidaResponse.builder().build();
        given(acogidaMapper.mapAddAcogidaRequestToAcogidaEntity(request)).willReturn(entity);
        given(acogidaRepository.save(entity)).willReturn(entity);
        given(acogidaMapper.mapAcogidaEntityToAddAcogidaResponse(entity)).willReturn(response);

        // When
        final AddAcogidaResponse result = acogidaService.addAcogida(request);

        // Then
        verify(acogidaMapper).mapAddAcogidaRequestToAcogidaEntity(request);
        verify(acogidaRepository).save(entity);
        verify(acogidaMapper).mapAcogidaEntityToAddAcogidaResponse(entity);
        assertThat(result).isEqualTo(response);
    }

    @Test
    void testGetAcogidas() {
        // Given
        final List<AcogidaEntity> entityList = new ArrayList<>();
        final List<GetAcogidaResponse> acogidaResponseList = new ArrayList<>();
        final GetAcogidasResponse response = GetAcogidasResponse.builder().getAcogidaResponses(acogidaResponseList).build();
        given(acogidaRepository.findAll()).willReturn(entityList);
        given(acogidaMapper.mapAcogidaEntityListToGetAcogidasResponse(entityList)).willReturn(acogidaResponseList);

        // When
        final GetAcogidasResponse result = acogidaService.getAcogidas();

        // Then
        verify(acogidaRepository).findAll();
        verify(acogidaMapper).mapAcogidaEntityListToGetAcogidasResponse(entityList);
        assertThat(result).isEqualTo(response);
    }

    @Test
    void testGetAcogida() {
        // Given
        final String acogidaId = "1";
        final AcogidaEntity entity = AcogidaEntity.builder().build();
        final GetAcogidaResponse response = GetAcogidaResponse.builder().build();
        given(acogidaRepository.findById(acogidaId)).willReturn(Optional.of(entity));
        given(acogidaMapper.mapAcogidaEntityToGetAcogidaResponse(entity)).willReturn(response);

        // When
        final GetAcogidaResponse result = acogidaService.getAcogida(acogidaId);

        // Then
        verify(acogidaRepository).findById(acogidaId);
        verify(acogidaMapper).mapAcogidaEntityToGetAcogidaResponse(entity);
        assertThat(result).isEqualTo(response);
    }

    @Test
    void testUpdateAcogida() {
        // given
        final String acogidaId = "1";
        final UpdateAcogidaRequest request = UpdateAcogidaRequest.builder().name("test").build();
        final AcogidaEntity acogidaEntityToUpdate = AcogidaEntity.builder().acogidaId(acogidaId).name(request.getName()).build();
        final AcogidaEntity updatedAcogidaEntity = AcogidaEntity.builder().name("test").build();
        final UpdateAcogidaResponse response = UpdateAcogidaResponse.builder().build();
        given(acogidaMapper.mapUpdateAcogidaRequestToAcogidaEntity(request)).willReturn(acogidaEntityToUpdate);
        given(acogidaRepository.save(acogidaEntityToUpdate)).willReturn(updatedAcogidaEntity);
        given(acogidaMapper.mapAcogidaEntityToUpdateAcogidaResponse(updatedAcogidaEntity)).willReturn(response);

        // when
        final UpdateAcogidaResponse result = acogidaService.updateAcogida(acogidaId, request);

        // then
        verify(acogidaRepository).save(acogidaEntityToUpdate);
        assertThat(result).isEqualTo(response);
    }

    @Test
    void testDeleteAcogida() {
        // given
        final String acogidaId = "1";
        doNothing().when(acogidaRepository).deleteById(acogidaId);

        // when
        final DeleteAcogidaResponse response = acogidaService.deleteAcogida(acogidaId);

        // then
        verify(acogidaRepository).deleteById(acogidaId);
        assertThat(response).isNotNull();
    }
}
