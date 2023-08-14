package com.example.bookapi.dto;

import com.example.bookapi.model.Evaluation;
import com.example.bookapi.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;

    private String isbn;

    private String name;

    private LocalDateTime creationDate = LocalDateTime.now();

    private String writerName;

    private LocalDateTime releaseDate;

    private List<GenreDto> genres;

    private List<Evaluation> evaluations;


}
