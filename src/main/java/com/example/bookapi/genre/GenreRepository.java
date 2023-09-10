package com.example.bookapi.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Optional<Genre> findByName(String name);



    @Query("select g.name from Book b join Genre g where b.id =:id  ")
    List<String> findGenresByBooks(int id);











}


