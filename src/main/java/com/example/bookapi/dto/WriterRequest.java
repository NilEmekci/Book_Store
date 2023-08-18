package com.example.bookapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriterRequest {


    @Max(30)
    @Min(value =2,message = "Name should greater than 2 character")
    private String name;

    @Min(value =2,message = "Surname should greater than 2 character")
    private String surname;

    private LocalDateTime birthDate;



}
