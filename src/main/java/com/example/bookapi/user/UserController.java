package com.example.bookapi.user;
/*
import com.example.bookapi.Book.BookDto;
import com.example.bookapi.Book.BookRequest;
import com.example.bookapi.dto.UserDto;
import com.example.bookapi.dto.UserRequest;
import com.example.bookapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<UserDto> add(@Valid @RequestBody UserRequest userRequest){
        return userService.add(userRequest);

    }

    @PutMapping("/updateSurname/{surname}")
    @PreAuthorize("hasAnyAuthority('user:create','admin:create')")
    public ResponseEntity<UserDto> updateSurname(@Valid @RequestBody UserRequest userRequest,@PathVariable String name){
        return userService.updateSurname(userRequest,name);

    }
    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteById(@PathVariable String id){
        userService.deleteById(id);

    }

    @GetMapping("/getByName/{name}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<UserDto> getByName(@PathVariable String name){
        return userService.getByName(name);

    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<UserDto> getById(@PathVariable String id){
        return userService.getById(id);

    }


}
*/