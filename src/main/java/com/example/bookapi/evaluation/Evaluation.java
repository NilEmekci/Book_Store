package com.example.bookapi.evaluation;

import com.example.bookapi.book.Book;
import com.example.bookapi.user.User;
import com.example.bookapi.writer.Writer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="evaluation")
public class Evaluation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator="UUID")
    //@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private int id;

    private LocalDateTime creationDate = LocalDateTime.now();

    private String massage;

    @Max(value = 5)
    @Min(value=1)
    private int rating;

    @ManyToOne
    @JoinColumn(name="user_mail")
    private User user;

    private boolean isBookEvaluation;

    @ManyToOne(optional = true)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(optional = true)
    @JoinColumn(name = "writer_id")
    private Writer writer;



}


