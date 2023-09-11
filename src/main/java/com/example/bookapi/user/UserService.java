package com.example.bookapi.user;

import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.exception.EntityNotNullException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return userConverter.convertTolistUserToUserDto(users);
    }

    public UserDto updateSurname(UserRequest userRequest, int id) {

        if(userRequest.getSurname().isBlank() || userRequest.getSurname() == null){
            throw new EntityNotNullException("User surname cannot be null or blank");
        }
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with this id"));

        User user = userRepository.findById(id).get();
        user.setSurname(userRequest.getSurname());
        userRepository.save(user);

        return userConverter.convertUsertoUserDto(user);
    }

    public void deleteById(int id) {
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with this id"));
        if (userToDelete == null) {
            throw new RuntimeException("User does not exist");
        } else userRepository.deleteById(id);
    }

    public UserDto getByName(String name) {

        if(name.isBlank() || name == null){
                throw new EntityNotNullException("User name cannot be null or blank");
        }
        User user = userRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("User not found with this name"));
        if (user == null) {
            throw new RuntimeException("User does not exist");
        }
        return userConverter.convertUsertoUserDto(user);
    }

    public UserDto getById(int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with this id"));
        if (user == null) {
            throw new RuntimeException("User does not exist");
        }
        return userConverter.convertUsertoUserDto(user);
    }


}
