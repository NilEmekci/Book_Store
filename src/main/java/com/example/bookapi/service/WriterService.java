package com.example.bookapi.service;

import com.example.bookapi.dto.WriterDto;
import com.example.bookapi.dto.WriterConverter;
import com.example.bookapi.dto.WriterRequest;
import com.example.bookapi.exception.EntityAlreadyExistException;
import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.exception.EntityNotNullException;
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

        if (writerRequest.getName() == null || writerRequest.getSurname() == null || writerRequest.getName().isBlank() ||writerRequest.getSurname().isBlank()) {
            throw new EntityNotNullException("Writer name or surname cannot be null or blank");
        }
        if(isWriterExist(writerRequest.getName(), writerRequest.getSurname(), writerRequest.getBirthDate())){
            throw new EntityAlreadyExistException("Writer already exist ");
        }

        Writer writer = writerConverter.convertWriterRequestToWriter(writerRequest);
        writerRepository.save(writer);

        return writerConverter.convertWritertoWriterDto(writer);

    }

    public WriterDto updateSurname(String surname, int id) {

        if(surname.isBlank() || surname == null){
            throw new EntityNotNullException("Writer name cannot be null or blank");
        }
        writerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Writer not found with this id"));

        Writer writer = writerRepository.findById(id).get();
        writer.setSurname(surname);
        writerRepository.save(writer);

        return writerConverter.convertWritertoWriterDto(writer);

    }

    public void deleteById(int id) {

        Writer writerToDelete = writerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Writer not found with this id"));
        if (writerToDelete == null) {
            throw new RuntimeException("Writer does not exist");
        } else writerRepository.deleteById(id);

    }

    public WriterDto getByName(String name) {

        if(name.isBlank() || name == null){
            throw new EntityNotNullException("Writer name cannot be null or blank");
        }

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

    private boolean isWriterExist(String writerName,String writerSurname,LocalDateTime writerBirthdate){

        if(writerRepository.findByName(writerName).isPresent() ){
            Writer writer = writerRepository.findByName(writerName).get();
            boolean checkSurname = writer.getSurname().equals(writerSurname);

            if(checkSurname){
                return writer.getBirthDate().equals(writerBirthdate);
            }

        }
        return false;
    }

}

