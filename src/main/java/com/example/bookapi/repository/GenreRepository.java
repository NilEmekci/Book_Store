package com.example.bookapi.repository;

import com.example.bookapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,String> {
}
