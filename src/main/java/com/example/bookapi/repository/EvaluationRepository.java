package com.example.bookapi.repository;

import com.example.bookapi.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation,String> {
}
