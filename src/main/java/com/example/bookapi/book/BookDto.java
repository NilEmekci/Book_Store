package com.example.bookapi.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
