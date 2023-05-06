package org.altruistas.awsiberiacruzroja.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class UpdateAcogidaResponse {
    @JsonProperty("acogida_id")
    private String acogidaId;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("last_updated_date")
    private Date lastUpdatedDate;
}
