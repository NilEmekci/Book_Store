package com.example.bookapi.book;

import com.example.bookapi.writer.Writer;
import com.example.bookapi.writer.WriterRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookConverter {

    private final WriterRepository writerRepository;
    private final BookRepository bookRepository;


    public BookConverter(WriterRepository writerRepository, BookRepository bookRepository) {
        this.writerRepository = writerRepository;
        this.bookRepository = bookRepository;
    }


    public List<BookDto> convertTolistBookToBookDto(@NotNull List<Book> from){

        List<BookDto> newItems = new ArrayList<>();

        for(Book book :from){
            BookDto responseItem = new BookDto();

            responseItem.setId(book.getId());
            responseItem.setIsbn(book.getIsbn());
            responseItem.setName(book.getName());

            responseItem.setWriterName(writerRepository.findWriterByBook(book.getName()));
            responseItem.setReleaseDate(book.getReleaseDate());

            newItems.add(responseItem);
        }
        return newItems;
    }
    public BookDto convertBooktoBookDto(Book from){

        BookDto newItem =new BookDto();

        newItem.setId(from.getId());
        newItem.setIsbn(from.getIsbn());
        newItem.setName(from.getName());

        newItem.setWriterName(writerRepository.findWriterByBook(from.getName()));
        newItem.setReleaseDate(from.getReleaseDate());

        return  newItem;
    }

    public Book convertBookRequestToBook(BookRequest from){

        Book newItem = new Book();

        newItem.setName(from.getName());
        newItem.setCreationDate(LocalDateTime.now());
        newItem.setReleaseDate(from.getReleaseDate());

        Writer writer = writerRepository.findById(from.getWriterId()).get();
        newItem.setWriter(writer);


        return newItem;

    }

}
