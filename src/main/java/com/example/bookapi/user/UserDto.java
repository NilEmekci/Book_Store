package com.example.bookapi.user;

import com.example.bookapi.evaluation.EvaluationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private List<EvaluationDto> Evaluations;


}
