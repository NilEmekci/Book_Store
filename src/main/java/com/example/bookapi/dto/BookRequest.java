package com.example.bookapi.dto;

import com.example.bookapi.model.Writer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private String name;

    private int writerId;

    private LocalDateTime releaseDate;


}
