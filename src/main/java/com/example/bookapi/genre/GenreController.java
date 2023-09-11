package com.example.bookapi.genre;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/v1/genre/")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class GenreController {

    private final GenreService genreService;


    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public List<GenreDto> getAll() {
        return genreService.getAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<GenreDto> add(@Valid @RequestBody GenreRequest genreRequest){
        return ResponseEntity.ok(genreService.add(genreRequest));
    }

    @PutMapping("/updateName/{name}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<GenreDto> updateName(@RequestBody String bookName, @PathVariable int id){
        return ResponseEntity.ok(genreService.updateName(bookName,id));
    }

    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteById(@PathVariable String id){
        genreService.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public ResponseEntity<GenreDto> getById(@PathVariable int id){
        return ResponseEntity.ok(genreService.getById(id));

    }

    @GetMapping("/getByName/{name}")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public ResponseEntity<GenreDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(genreService.getByName(name));
    }


}
