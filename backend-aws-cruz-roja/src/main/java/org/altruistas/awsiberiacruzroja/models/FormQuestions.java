package org.altruistas.awsiberiacruzroja.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamoDBDocument
public class FormQuestions {
    @JsonProperty("question_id")
    @DynamoDBAttribute(attributeName = "question_id")
    private String questionId;

    @JsonProperty("answer_id")
    @DynamoDBAttribute(attributeName = "answer_id")
    private String answerId;
}
