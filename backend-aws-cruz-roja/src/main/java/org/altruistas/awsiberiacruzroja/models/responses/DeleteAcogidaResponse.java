package org.altruistas.awsiberiacruzroja.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeleteAcogidaResponse {
    @JsonProperty("acogida_id")
    private String acogidaId;
}
