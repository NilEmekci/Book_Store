package com.example.bookapi.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationRequest {

    private String userEmail;

    private boolean isBookEvaluation;

    private int bookId;

    private int writerId;

    private String message;

    private int rating;




}
