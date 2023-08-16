package com.example.bookapi.dto;

import com.example.bookapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationRequest {

    private String userNickName;

    private boolean isBookEvaluation;

    private int rating;

    private String message;



}
