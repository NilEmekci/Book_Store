package com.example.bookapi.dto;

import com.example.bookapi.model.Book;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class GenreDto {

    private int id;
    private String name;
    private List<BookDto> books;

}
