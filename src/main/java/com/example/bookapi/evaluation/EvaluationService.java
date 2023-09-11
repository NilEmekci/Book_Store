package com.example.bookapi.evaluation;

import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.user.User;
import com.example.bookapi.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final EvaluationConverter evaluationConverter;
    private final UserRepository userRepository;



    public EvaluationService(EvaluationRepository evaluationRepository, EvaluationConverter evaluationConverter, UserRepository userRepository) {
        this.evaluationRepository = evaluationRepository;
        this.evaluationConverter = evaluationConverter;
        this.userRepository = userRepository;

    }


    public EvaluationDto add(EvaluationRequest evaluationRequest) {

        User user = userRepository.findByEmail(evaluationRequest.getUserEmail()).orElseThrow(()-> new EntityNotFoundException("User not found with this id"));

        Evaluation evaluation = evaluationConverter.convertEvaluationRequestToEvaluation(evaluationRequest);
        evaluationRepository.save(evaluation);

        return evaluationConverter.convertEvaluationtoEvaluationDto(evaluation);
    }
    public List<EvaluationDto> getAll() {
        List<Evaluation> evaluations = evaluationRepository.findAll();
        return evaluationConverter.convertTolistEvaluationToEvaluationDto(evaluations);
    }

    public void deleteById(int id) {

        Evaluation evaluationToDelete = evaluationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Evaluation not found with this id"));
        if (evaluationToDelete == null) {
            throw new RuntimeException("Evaluation does not exist");
        } else evaluationRepository.deleteById(id);
    }

    public EvaluationDto updateRating(EvaluationRequest evaluationRequest, int evaluationId) {


        Evaluation evaluation = evaluationRepository.findById(evaluationId).orElseThrow(() -> new EntityNotFoundException("Evaluation not found with this id"));
        evaluation.setRating(evaluationRequest.getRating());
        evaluationRepository.save(evaluation);
        return evaluationConverter.convertEvaluationtoEvaluationDto(evaluation);

    }

    public EvaluationDto updateMessage(EvaluationRequest evaluationRequest, int evaluationId) {

        Evaluation evaluation = evaluationRepository.findById(evaluationId).orElseThrow(() -> new EntityNotFoundException("Evaluation not found with this id"));
        evaluation.setMassage(evaluationRequest.getMessage());
        evaluationRepository.save(evaluation);
        return evaluationConverter.convertEvaluationtoEvaluationDto(evaluation);
    }

    public EvaluationDto getById(int id) {

        Evaluation evaluation = evaluationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Evaluation not found with this id"));
        if (evaluation == null) {
            throw new RuntimeException("Evaluation does not exist");
        }
        return evaluationConverter.convertEvaluationtoEvaluationDto(evaluation);
    }
}
