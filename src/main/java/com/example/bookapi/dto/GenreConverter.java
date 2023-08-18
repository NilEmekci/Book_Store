package com.example.bookapi.dto;

import com.example.bookapi.model.Genre;
import com.example.bookapi.repository.GenreRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class GenreConverter {

    private final GenreRepository genreRepository;

    private final BookConverter bookConverter;


    public GenreConverter(GenreRepository genreRepository, BookConverter bookConverter) {
        this.genreRepository = genreRepository;
        this.bookConverter = bookConverter;
    }

    public List<GenreDto> convertTolistGenreToGenreDto(@NotNull List<Genre> from){

        List<GenreDto> newItems = new ArrayList<>();

        for(Genre genre :from){
            GenreDto responseItem = new GenreDto();

            responseItem.setId(genre.getId());
            responseItem.setName(genre.getName());
            responseItem.setBooks(bookConverter.convertTolistBookToBookDto(genre.getBooks()));
            newItems.add(responseItem);
        }
        return newItems;
    }
    public GenreDto convertGenretoGenreDto(Genre from){

        GenreDto newItem = new GenreDto();

        newItem.setId(from.getId());
        newItem.setName(from.getName());
        newItem.setBooks(bookConverter.convertTolistBookToBookDto(from.getBooks()));
        return  newItem;
    }

    public Genre convertGenreRequestToGenre(GenreRequest from){

        Genre newItem = new Genre();

        newItem.setName(from.getName());
        newItem.setCreationDate(LocalDateTime.now());
        return newItem;

    }


}
