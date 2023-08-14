package com.example.bookapi.repository;

import com.example.bookapi.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WriterRepository extends JpaRepository<Writer,Long> {



}
