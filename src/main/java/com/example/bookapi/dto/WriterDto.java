package com.example.bookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriterDto {

    private int id;

    private String name;

    private String surname;

    private List<String> booksName;

}