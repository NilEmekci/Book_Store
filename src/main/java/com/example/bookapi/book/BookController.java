package com.example.bookapi.book;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/v1/book")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public List<BookDto> getAll(){
        return bookService.getAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<BookDto> add(@Valid @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.add(bookRequest));

    }

    @PutMapping("/updateName/{name}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<BookDto> updateName(@Valid @RequestBody String bookName,@PathVariable int id){
        return ResponseEntity.ok(bookService.updateName(bookName,id));

    }
    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteById(@PathVariable int id){
        bookService.deleteById(id);

    }

    @GetMapping("/getByName/{name}")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public ResponseEntity<BookDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(bookService.getByName(name));

    }

    @GetMapping("/getByISBN/{isbn}")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public ResponseEntity<BookDto> getById(@PathVariable String isbn){
        return ResponseEntity.ok(bookService.getByISBN(isbn));

    }



}
