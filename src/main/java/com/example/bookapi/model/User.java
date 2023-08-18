package com.example.bookapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator="UUID")
    //@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private int id;

    @NotNull
    private String name;

    private LocalDateTime creationDate = LocalDateTime.now();

    @NotNull
    private String surname;

    @Length(min =3, max=15)
    private String nickName;

    @Email
    private String email;

    @NotNull
    private String password;


}