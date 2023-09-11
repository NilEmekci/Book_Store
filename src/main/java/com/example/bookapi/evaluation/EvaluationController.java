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
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('user:read','admin:read')")
    public ResponseEntity<EvaluationDto> getAll(){
        return evaluationService.getAll();
    }


    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('user:create','admin:create')")
    public ResponseEntity<EvaluationDto> add(@Valid @RequestBody EvaluationRequest evaluationRequest){
        return evaluationService.add(evaluationRequest);
    }


    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAnyAuthority('user:delete','admin:delete')")
    public void deleteById(@PathVariable String id){
        evaluationService.deleteById(id);
    }

    @PutMapping("/updateRating/{rating}")
    @PreAuthorize("hasAnyAuthority('user:update','admin:update')")
    public ResponseEntity<EvaluationDto> updateRating(@Valid @RequestBody EvaluationRequest evaluationRequest,
                                                      @PathVariable String rating){
        return evaluationService.updateRating(evaluationRequest,rating);
    }

    @PutMapping("/updateMessage/{message}")
    @PreAuthorize("hasAnyAuthority('user:update','admin:update')")
    public ResponseEntity<EvaluationDto> updateMessage(@Valid @RequestBody EvaluationRequest evaluationRequest,
                                                       @PathVariable String message){
        return evaluationService.updateMessage(evaluationRequest,message);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<EvaluationDto> getByName(@PathVariable String id){
        return evaluationService.getById(id);
    }


}
*/