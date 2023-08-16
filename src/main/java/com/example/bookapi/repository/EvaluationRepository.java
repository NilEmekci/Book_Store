package com.example.bookapi.repository;

import com.example.bookapi.model.Evaluation;
import com.example.bookapi.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {


}
