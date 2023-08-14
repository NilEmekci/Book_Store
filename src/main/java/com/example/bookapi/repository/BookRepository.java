package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {

    @Query("select b.name from Book b where b.writer.id =:id  ")
    List<String> findBooksByWriter(Long id);






}
