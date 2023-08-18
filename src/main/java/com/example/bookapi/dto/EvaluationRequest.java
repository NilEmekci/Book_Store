package com.example.bookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationRequest {

    private String userNickName;

    private boolean isBookEvaluation;

    private int rating;

    private String message;



}
