package com.example.bookapi.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {


}
