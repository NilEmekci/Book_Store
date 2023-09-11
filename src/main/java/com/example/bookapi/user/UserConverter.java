package com.example.bookapi.user;

import com.example.bookapi.writer.Writer;
import com.example.bookapi.writer.WriterDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConverter {

    public List<UserDto> convertTolistUserToUserDto(@NotNull List<User> from){

        List<UserDto> newItems = new ArrayList<>();

        for(User user :from){
            UserDto responseItem = new UserDto();
            responseItem.setId(user.getId());
            responseItem.setName(user.getName());
            responseItem.setSurname(user.getSurname());
            responseItem.setPassword(user.getPassword());
            responseItem.setEmail(user.getEmail());
            responseItem.setEvaluations(new ArrayList<>());
            newItems.add(responseItem);
        }
        return newItems;
    }

    public UserDto convertUsertoUserDto(User from) {

        UserDto newItem =new UserDto();

        newItem.setId(from.getId());
        newItem.setName(from.getName());
        newItem.setSurname(from.getSurname());
        newItem.setEmail(from.getEmail());
        newItem.setPassword(from.getPassword());
        newItem.setEvaluations(new ArrayList<>());

        return  newItem;

    }


}
