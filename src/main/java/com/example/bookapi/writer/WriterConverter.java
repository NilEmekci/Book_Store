package com.example.bookapi.writer;

import com.example.bookapi.book.Book;
import com.example.bookapi.book.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class WriterConverter {


    private final WriterRepository writerRepository;
    private final BookRepository bookRepository;


    public WriterConverter(WriterRepository writerRepository, BookRepository bookRepository) {
        this.writerRepository = writerRepository;
        this.bookRepository = bookRepository;
    }


    public List<WriterDto> convertTolistWriterToWriterDto(@NotNull List<Writer> from){

        List<WriterDto> newItems = new ArrayList<>();

        for(Writer writer :from){
            WriterDto responseItem = new WriterDto();
            responseItem.setId(writer.getId());
            responseItem.setName(writer.getName());
            responseItem.setSurname(writer.getSurname());
            responseItem.setBooksName(bookRepository.findBooksByWriter(writer.getId()));

            newItems.add(responseItem);
        }
        return newItems;
    }

    public WriterDto convertWritertoWriterDto(Writer from){

        WriterDto newItem =new WriterDto();

        newItem.setId(from.getId());
        newItem.setName(from.getName());
        newItem.setSurname(from.getSurname());
        newItem.setBooksName(bookRepository.findBooksByWriter(from.getId()));

        return  newItem;
    }

    public Writer convertWriterRequestToWriter(WriterRequest from){

        Writer newItem = new Writer();
        newItem.setName(from.getName());
        newItem.setSurname(from.getSurname());
        newItem.setCreationDate(LocalDateTime.now());
        newItem.setBirthDate(from.getBirthDate());

        List<Book> books =bookRepository.findBooksByWriterName(from.getName(), from.getSurname());
        newItem.setBooks(books);

        return newItem;

    }






}
