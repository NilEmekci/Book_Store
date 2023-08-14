package com.example.bookapi.controller;
/*
import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/v1(book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<BookDto> getAll(){
        return bookService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<BookDto> add(@Valid @RequestBody BookRequest bookRequest){
        return bookService.add(bookRequest);

    }

    @PostMapping("/updateName/{name}")
    public ResponseEntity<BookDto> updateName(@Valid @RequestBody BookRequest bookRequest,@PathVariable String name){
        return bookService.updateName(bookRequest,name);

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id){
        bookService.deleteById(id);

    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<BookDto> getByName(@PathVariable String name){
        return bookService.getByName(name);

    }

    @GetMapping("/getByISBN/{isbn}")
    public ResponseEntity<BookDto> getById(@PathVariable String isbn){
        return bookService.getByISBN(isbn);

    }



}
*/