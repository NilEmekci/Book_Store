package com.example.bookapi.service;

import com.example.bookapi.dto.WriterDto;
import com.example.bookapi.dto.WriterConverter;
import com.example.bookapi.dto.WriterRequest;
import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.model.Writer;
import com.example.bookapi.repository.WriterRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WriterService {

    private final WriterRepository writerRepository;
    private final WriterConverter writerConverter;
    private final BookService bookService;


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

        Writer writer = writerConverter.convertWriterRequestToWriter(writerRequest);
        writerRepository.save(writer);

        return writerConverter.convertWritertoWriterDto(writer);

    }

    public WriterDto updateSurname(String surname, int id) {

        writerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Writer not found with this id"));

        Writer writer = writerRepository.findById(id).get();
        writer.setSurname(surname);
        writerRepository.save(writer);

        return writerConverter.convertWritertoWriterDto(writer);

    }

    public void deleteById(int id) {
        Writer writerToDelete = writerRepository.getById(id);
        if (writerToDelete == null) {
            throw new RuntimeException("User does not exist");
        } else writerRepository.deleteById(id);

    }

    public WriterDto getByName(String name) {

        Writer writer = writerRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Writer not found with this name"));
        if (writer == null) {
            throw new RuntimeException("Writer does not exist");
        }
        return writerConverter.convertWritertoWriterDto(writer);
    }

    public WriterDto getById(int id) {
        Writer writer = writerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Writer not found with this id"));
        if (writer == null) {
            throw new RuntimeException("Writer does not exist");
        }
        return writerConverter.convertWritertoWriterDto(writer);

    }

}

