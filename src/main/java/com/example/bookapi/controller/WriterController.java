package com.example.bookapi.controller;

import com.example.bookapi.dto.WriterDto;
import com.example.bookapi.dto.WriterRequest;
import com.example.bookapi.service.WriterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/writer")
public class WriterController {

    private final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }
    @GetMapping("/getAll")
    public List<WriterDto> getAll() {
        return writerService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<WriterDto> add(@Valid @RequestBody WriterRequest writerRequest) {
        return ResponseEntity.ok(writerService.add(writerRequest));
    }
    @PostMapping("/updateSurname/{id}")
    public ResponseEntity<WriterDto> updateSurname(@Valid @RequestBody String surname, @PathVariable int id) {
        return ResponseEntity.ok(writerService.updateSurname(surname, id));
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        writerService.deleteById(id);

    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<WriterDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(writerService.getByName(name));

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<WriterDto> getById(@PathVariable int id){
        return ResponseEntity.ok(writerService.getById(id));

    }



}
