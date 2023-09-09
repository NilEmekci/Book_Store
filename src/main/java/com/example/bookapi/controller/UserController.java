package com.example.bookapi.controller;
/*
import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.dto.UserDto;
import com.example.bookapi.dto.UserRequest;
import com.example.bookapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> add(@Valid @RequestBody UserRequest userRequest){
        return userService.add(userRequest);

    }

    @PutMapping("/updateSurname/{surname}")
    public ResponseEntity<UserDto> updateSurname(@Valid @RequestBody UserRequest userRequest,@PathVariable String name){
        return userService.updateSurname(userRequest,name);

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id){
        userService.deleteById(id);

    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<UserDto> getByName(@PathVariable String name){
        return userService.getByName(name);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable String id){
        return userService.getById(id);

    }


}
*/