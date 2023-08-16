package com.example.bookapi.repository;

import com.example.bookapi.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer,Integer> {

    Optional<Writer> findByName(String name);

    @Query("select w.name from Writer w, Book b  where b.name=:bookName and w.id = b.writer.id")
    String findWriterByBook(String bookName);



}
