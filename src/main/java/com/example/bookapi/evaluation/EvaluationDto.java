package com.example.bookapi.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {


    private String userName;

    private boolean isBookEvaluation;

    private int bookId;

    private int writerId;

    private int rating;

    private String massage;

}
