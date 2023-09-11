package com.example.bookapi.evaluation;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<EvaluationDto> getAll(){
        return evaluationService.getAll();
    }


    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('user:create','admin:create')")
    public ResponseEntity<EvaluationDto> add(@Valid @RequestBody EvaluationRequest evaluationRequest){
        return ResponseEntity.ok(evaluationService.add(evaluationRequest));
    }


    @DeleteMapping("/deleteById/{id}")
    @PreAuthorize("hasAnyAuthority('user:delete','admin:delete')")
    public void deleteById(@PathVariable int id){
        evaluationService.deleteById(id);
    }

    @PutMapping("/updateRating/{rating}")
    @PreAuthorize("hasAnyAuthority('user:update','admin:update')")
    public ResponseEntity<EvaluationDto> updateRating(@Valid @RequestBody EvaluationRequest evaluationRequest,
                                                      @PathVariable int evaluationId){
        return ResponseEntity.ok(evaluationService.updateRating(evaluationRequest,evaluationId));
    }

    @PutMapping("/updateMessage/{message}")
    @PreAuthorize("hasAnyAuthority('user:update','admin:update')")
    public ResponseEntity<EvaluationDto> updateMessage(@Valid @RequestBody EvaluationRequest evaluationRequest,
                                                       @PathVariable int evaluationId){
        return ResponseEntity.ok(evaluationService.updateMessage(evaluationRequest,evaluationId));
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<EvaluationDto> getByName(@PathVariable int id){
        return ResponseEntity.ok(evaluationService.getById(id));
    }


}
