package com.example.bookapi.repository;

import com.example.bookapi.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {


}
