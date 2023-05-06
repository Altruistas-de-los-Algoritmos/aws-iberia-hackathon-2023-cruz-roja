package org.altruistas.awsiberiacruzroja.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetAcogidasResponse {
    @JsonProperty("result")
    private List<GetAcogidaResponse> getAcogidaResponses;
}
