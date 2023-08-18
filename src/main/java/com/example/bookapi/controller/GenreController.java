package com.example.bookapi.controller;

import com.example.bookapi.dto.GenreDto;
import com.example.bookapi.dto.GenreRequest;
import com.example.bookapi.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/v1/genre/")
public class GenreController {

    private final GenreService genreService;


    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/getAll")
    public List<GenreDto> getAll() {
        return genreService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<GenreDto> add(@Valid @RequestBody GenreRequest genreRequest){
        return ResponseEntity.ok(genreService.add(genreRequest));
    }

    @PostMapping("/updateName/{name}")
    public ResponseEntity<GenreDto> updateName(@RequestBody String bookName, @PathVariable int id){
        return ResponseEntity.ok(genreService.updateName(bookName,id));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id){
        genreService.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GenreDto> getById(@PathVariable int id){
        return ResponseEntity.ok(genreService.getById(id));

    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<GenreDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(genreService.getByName(name));
    }


}
