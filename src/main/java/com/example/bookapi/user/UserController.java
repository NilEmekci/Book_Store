package com.example.bookapi.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PutMapping("/updateSurname/{id}")
    @PreAuthorize("hasAnyAuthority('user:create','admin:create')")
    public ResponseEntity<UserDto> updateSurname(@Valid @RequestBody UserRequest userRequest,@PathVariable int id){
        return ResponseEntity.ok(userService.updateSurname(userRequest,id));

    }
    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteById(@PathVariable int id){
        userService.deleteById(id);

    }

    @GetMapping("/getByName/{name}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<UserDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(userService.getByName(name));

    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<UserDto> getById(@PathVariable int id){
        return ResponseEntity.ok(userService.getById(id));

    }


}
