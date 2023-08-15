package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select b.name from Book b where b.writer.id =:id  ")
    List<String> findBooksByWriter(int id);


    @Query("select '*' from Book b where b.writer.name=:writerName")
    List<Book> findBooksByWriterName(String writerName);
}
