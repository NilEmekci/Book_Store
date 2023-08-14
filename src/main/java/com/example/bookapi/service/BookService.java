package com.example.bookapi.service;

import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto createBook(BookRequest bookRequest){
        return null;

    }
    public List<String> getAllBooksNameByWriterId(Long writerId){
        return bookRepository.findBooksByWriter(writerId);

    }
/*
    public ResponseEntity<BookDto> getAll() {
    }

    public ResponseEntity<BookDto> add(BookRequest bookRequest) {
    }

    public ResponseEntity<BookDto> updateName(BookRequest bookRequest, String name) {
    }



    public ResponseEntity<BookDto> getByName(String name) {
    }

    public ResponseEntity<BookDto> getByISBN(String isbn) {
    }

    public void deleteById(String id) {
    }

 */
}
