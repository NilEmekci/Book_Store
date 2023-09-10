package com.example.bookapi.genre;

import com.example.bookapi.exception.EntityAlreadyExistException;
import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.exception.EntityNotNullException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreConverter genreConverter;

    public GenreService(GenreRepository genreRepository, GenreConverter genreConverter) {
        this.genreRepository = genreRepository;
        this.genreConverter = genreConverter;
    }


    public List<GenreDto> getAll(){
        List<Genre> genres = genreRepository.findAll();
        return genreConverter.convertTolistGenreToGenreDto(genres);
    }
    public GenreDto add(GenreRequest genreRequest) {

        if (genreRequest.getName() == null || genreRequest.getName().isBlank() ) {
            throw new EntityNotNullException("Genre name cannot be null or blank");
        }
        genreRepository.findByName(genreRequest.getName()).ifPresent(l-> {throw new EntityAlreadyExistException("Genre already exist with this name");});
        Genre genre = genreConverter.convertGenreRequestToGenre(genreRequest);
        genreRepository.save(genre);

        return genreConverter.convertGenretoGenreDto(genre);
    }
    public void deleteById(String name) {

        if (name == null || name.isBlank() ) {
            throw new EntityNotNullException("Genre name cannot be null or blank");
        }
        Genre genreToDelete = genreRepository.findByName(name).orElseThrow(()-> new EntityNotFoundException("Genre not found with this id"));
        if (genreToDelete == null) {
            throw new RuntimeException("Genre does not exist");
        } else genreRepository.deleteById(genreToDelete.getId());
    }
    public GenreDto getById(int id) {

        Genre genre = genreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Genre not found with this id"));
        if (genre == null) {
            throw new RuntimeException("Genre does not exist");
        }
        return genreConverter.convertGenretoGenreDto(genre);
    }
    public GenreDto getByName(String name) {

        if (name == null || name.isBlank() ) {
            throw new EntityNotNullException("Genre name cannot be null or blank");
        }
        Genre genre = genreRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Genre not found with this name"));
        if (genre == null) {
            throw new RuntimeException("Genre does not exist");
        }
        return genreConverter.convertGenretoGenreDto(genre);
    }
    public GenreDto updateName(String genreName, int id) {

        if (genreName == null || genreName.isBlank() ) {
            throw new EntityNotNullException("Genre name cannot be null or blank");
        }
        Genre genre = genreRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Genre not found with this id"));
        genre.setName(genreName);
        genreRepository.save(genre);

        return genreConverter.convertGenretoGenreDto(genre);
    }

}
