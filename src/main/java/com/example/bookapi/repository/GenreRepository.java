package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import com.example.bookapi.model.Genre;
import com.example.bookapi.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Optional<Genre> findByName(String name);


}


