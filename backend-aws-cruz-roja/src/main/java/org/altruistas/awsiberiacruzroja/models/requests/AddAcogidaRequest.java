package org.altruistas.awsiberiacruzroja.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.altruistas.awsiberiacruzroja.models.FormQuestions;
import org.altruistas.awsiberiacruzroja.models.GenderEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddAcogidaRequest {
    @JsonProperty("form_questions")
    @NotNull(message = "Form questions cannot be null")
    private List<FormQuestions> formQuestions;

    @JsonProperty("name")
    @NotEmpty(message = "Name cannot be null or empty")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    @Email(message = "Email should be valid")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("nif")
    private String nif;

    @JsonProperty("age")
    @NotNull(message = "Age cannot be null")
    @PositiveOrZero
    private Integer age;

    @JsonProperty("gender")
    @NotNull(message = "Gender cannot be null")
    private GenderEnum gender;
}
