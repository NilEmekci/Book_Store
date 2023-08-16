package com.example.bookapi.service;

import com.example.bookapi.dto.BookConverter;
import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.repository.WriterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    private final BookRepository bookRepository;
    private  final BookConverter bookConverter;
    private  final WriterRepository writerRepository;


    public BookService(BookRepository bookRepository, BookConverter bookConverter, WriterRepository writerRepository) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
        this.writerRepository = writerRepository;
    }

    public List<BookDto> getAll() {

        List<Book> books = bookRepository.findAll();
        return bookConverter.convertTolistBookToBookDto(books);

    }
    public BookDto add(BookRequest bookRequest) {

        writerRepository.findById(bookRequest.getWriterId()).orElseThrow(()-> new EntityNotFoundException("Writer does not found with this id"));

        Book book = bookConverter.convertBookRequestToBook(bookRequest);
        bookRepository.save(book);

        return bookConverter.convertBooktoBookDto(book);
    }

    public BookDto updateName(String bookName, int id) {

        Book book = bookRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Book not found with this id"));
        book.setName(bookName);
        bookRepository.save(book);

        return bookConverter.convertBooktoBookDto(book);
    }

    public BookDto getByName(String name) {

        Book book =bookRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Book not found with this name"));
        if (book == null) {
            throw new RuntimeException("Book does not exist");
        }
        return bookConverter.convertBooktoBookDto(book);

    }

    public BookDto getByISBN(String isbn) {

        Book book =bookRepository.findByIsbn(isbn).orElseThrow(()->new EntityNotFoundException("Book not found with this isbn"));

        if (book == null) {
            throw new RuntimeException("Book does not exist");
        }
        return bookConverter.convertBooktoBookDto(book);
    }

    public void deleteById(int id) {

        Book bookToDelete = bookRepository.getById(id);
        if (bookToDelete == null) {
            throw new RuntimeException("User does not exist");
        } else bookRepository.deleteById(id);

    }

    public List<String> getAllBooksNameByWriterId(int writerId){
        return bookRepository.findBooksByWriter(writerId);

    }
    public List<Book> getAllBooksNameByWriterName(String writerName, String writerSurname){
        return bookRepository.findBooksByWriterName(writerName, writerSurname);

    }


}
