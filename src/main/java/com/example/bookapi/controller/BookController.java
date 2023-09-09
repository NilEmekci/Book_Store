package com.example.bookapi.controller;

import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/v1/book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<BookDto> getAll(){
        return bookService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<BookDto> add(@Valid @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.add(bookRequest));

    }

    @PutMapping("/updateName/{name}")
    public ResponseEntity<BookDto> updateName(@Valid @RequestBody String bookName,@PathVariable int id){
        return ResponseEntity.ok(bookService.updateName(bookName,id));

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        bookService.deleteById(id);

    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<BookDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(bookService.getByName(name));

    }

    @GetMapping("/getByISBN/{isbn}")
    public ResponseEntity<BookDto> getById(@PathVariable String isbn){
        return ResponseEntity.ok(bookService.getByISBN(isbn));

    }



}
