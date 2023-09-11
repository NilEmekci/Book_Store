package com.example.bookapi.writer;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/writer")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class WriterController {

    private final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }
    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public List<WriterDto> getAll() {
        return writerService.getAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<WriterDto> add(@Valid @RequestBody WriterRequest writerRequest) {
        return ResponseEntity.ok(writerService.add(writerRequest));
    }
    @PutMapping("/updateSurname/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<WriterDto> updateSurname(@Valid @RequestBody String surname, @PathVariable int id) {
        return ResponseEntity.ok(writerService.updateSurname(surname, id));
    }
    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteById(@PathVariable int id){
        writerService.deleteById(id);

    }
    @GetMapping("/getByName/{name}")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public ResponseEntity<WriterDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(writerService.getByName(name));

    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public ResponseEntity<WriterDto> getById(@PathVariable int id){
        return ResponseEntity.ok(writerService.getById(id));

    }

}
