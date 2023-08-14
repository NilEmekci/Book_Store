/*
package com.example.bookapi.controller;

import com.example.bookapi.dto.EvaluationDto;
import com.example.bookapi.dto.EvaluationRequest;
import com.example.bookapi.service.EvaluationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/evaluation")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<EvaluationDto> getAll(){
        return evaluationService.getAll();
    }


    @PostMapping("/add")
    public ResponseEntity<EvaluationDto> add(@Valid @RequestBody EvaluationRequest evaluationRequest){
        return evaluationService.add(evaluationRequest);
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id){
        evaluationService.deleteById(id);
    }

    @PostMapping("/updateRating/{rating}")
    public ResponseEntity<EvaluationDto> updateRating(@Valid @RequestBody EvaluationRequest evaluationRequest,
                                                      @PathVariable String rating){
        return evaluationService.updateRating(evaluationRequest,rating);
    }

    @PostMapping("/updateMessage/{message}")
    public ResponseEntity<EvaluationDto> updateMessage(@Valid @RequestBody EvaluationRequest evaluationRequest,
                                                       @PathVariable String message){
        return evaluationService.updateMessage(evaluationRequest,message);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EvaluationDto> getByName(@PathVariable String id){
        return evaluationService.getById(id);
    }


}
*/