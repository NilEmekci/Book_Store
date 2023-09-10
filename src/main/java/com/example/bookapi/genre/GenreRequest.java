package com.example.bookapi.genre;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreRequest {

    @Max(value = 80,message = "Genre name can not greater than 80 character")
    @Min(value = 3,message = "Genre name can not lower than 3 character")
    private String name;


}
