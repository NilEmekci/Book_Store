package com.example.bookapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @GeneratedValue(generator="UUID")
    //@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="book_genres",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "genres_id") )
    private List<Book> books;

    private LocalDateTime creationDate = LocalDateTime.now();
}
