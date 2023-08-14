package com.example.bookapi.service;

import com.example.bookapi.dto.WriterDto;
import com.example.bookapi.dto.WriterRequest;
import com.example.bookapi.model.Writer;
import com.example.bookapi.repository.WriterRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WriterService {

    private final WriterRepository writerRepository;
    private final BookService bookService;


    public WriterService(WriterRepository writerRepository, BookService bookService) {
        this.writerRepository = writerRepository;
        this.bookService = bookService;
    }

    public List<WriterDto> getAll() {
        List<Writer> writers = writerRepository.findAll();
        List<WriterDto> writerResponse = new ArrayList<>();
        for (Writer writer : writers) {
            WriterDto responseItem = new WriterDto();
            responseItem.setName(writer.getName());
            responseItem.setSurname(writer.getSurname());
            responseItem.setId(writer.getId());
            responseItem.setBooksName(bookService.getAllBooksNameByWriterId(writer.getId()));

            writerResponse.add(responseItem);
        }
        return writerResponse;
    }
}
/*
    public WriterDto add(@Valid WriterRequest writerRequest) {

            Writer newItem = new Writer();
            newItem.setName(writerRequest.getName());
            newItem.setSurname(writerRequest.getSurname());

            writerRepository.save(newItem);

            return writerDtoConverter.convert(newItem);

    }



    public WriterDto updateSurname(WriterRequest writerRequest, String surname) {



    }



    public void deleteById(String id) {
    }

    public ResponseEntity<WriterDto> getByName(String name) {
    }

    public ResponseEntity<WriterDto> getById(String id) {
    }

 */

