package com.example.bookapi.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {



    @Min(value =2,message = "Name should greater than 2 character")
    private String name;

    private int writerId;

    private LocalDateTime releaseDate;


}
