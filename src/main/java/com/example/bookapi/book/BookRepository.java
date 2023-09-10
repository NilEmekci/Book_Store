package com.example.bookapi.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findByName(String name);


    Optional<Book> findByIsbn(String isbn);

    @Query("select b.name from Book b where b.writer.id =:id  ")
    List<String> findBooksByWriter(int id);


    @Query("select '*' from Book b where b.writer.name=:writerName and b.writer.surname= :writerSurname")
    List<Book> findBooksByWriterName(String writerName, String writerSurname);


}
