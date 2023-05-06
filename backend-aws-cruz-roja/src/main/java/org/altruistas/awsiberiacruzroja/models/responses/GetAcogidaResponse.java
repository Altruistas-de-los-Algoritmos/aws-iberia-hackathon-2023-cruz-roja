package org.altruistas.awsiberiacruzroja.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.altruistas.awsiberiacruzroja.models.FormQuestions;
import org.altruistas.awsiberiacruzroja.models.GenderEnum;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class GetAcogidaResponse {
    @JsonProperty("acogida_id")
    private String acogidaId;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("last_updated_date")
    private Date lastUpdatedDate;

    @JsonProperty("form_questions")
    private List<FormQuestions> formQuestions;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("nif")
    private String nif;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("gender")
    private GenderEnum gender;
}
