package com.example.bookapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="writer")
public class Writer {


   // @GeneratedValue(generator="UUID")
    //@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private LocalDateTime creationDate = LocalDateTime.now();

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    @Past
    private LocalDateTime birthDate;



}
