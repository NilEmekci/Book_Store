package com.example.bookapi.genre;

import com.example.bookapi.book.BookDto;
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
