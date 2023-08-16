package com.example.bookapi.dto;

import com.example.bookapi.model.Book;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    private int id;
    private String name;
    private List<BookDto> books;

}
