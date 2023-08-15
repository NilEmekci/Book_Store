package com.example.bookapi.service;

import com.example.bookapi.dto.WriterDto;
import com.example.bookapi.dto.WriterConverter;
import com.example.bookapi.dto.WriterRequest;
import com.example.bookapi.model.Writer;
import com.example.bookapi.repository.WriterRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WriterService {

    private final WriterRepository writerRepository;
    private  final WriterConverter writerConverter;
    private  final BookService bookService;


    public WriterService(WriterRepository writerRepository, WriterConverter writerConverter, BookService bookService) {
        this.writerRepository = writerRepository;
        this.writerConverter = writerConverter;
        this.bookService = bookService;
    }


    public List<WriterDto> getAll() {
        List<Writer> writers = writerRepository.findAll();
        return writerConverter.convertTolistWriterToWriterDto(writers);
    }


    public WriterDto add(@Valid WriterRequest writerRequest) {

        Writer writer= writerConverter.convertWriterRequestToWriter(writerRequest);
        writerRepository.save(writer);

        return writerConverter.convertWritertoWriterDto(writer);

    }
}
/*



    public WriterDto updateSurname(WriterRequest writerRequest, String surname) {



    }



    public void deleteById(String id) {
    }

    public ResponseEntity<WriterDto> getByName(String name) {
    }

    public ResponseEntity<WriterDto> getById(String id) {
    }

 */

