package com.example.bookapi.dto;

import com.example.bookapi.model.Evaluation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private int id;

    private String name;

    private String surname;

    private String nickName;

    private String email;

    private String password;

    private List<EvaluationDto> Evaluations;


}
