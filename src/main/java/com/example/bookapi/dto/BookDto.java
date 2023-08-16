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

    private int id;

    private String isbn;

    private String name;

    private String writerName;

    private LocalDateTime releaseDate;




}
