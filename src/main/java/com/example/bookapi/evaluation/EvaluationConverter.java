package com.example.bookapi.evaluation;

import com.example.bookapi.book.Book;
import com.example.bookapi.book.BookRepository;
import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.user.User;
import com.example.bookapi.user.UserRepository;
import com.example.bookapi.writer.Writer;
import com.example.bookapi.writer.WriterRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class EvaluationConverter {

    private final EvaluationRepository evaluationRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final WriterRepository writerRepository;

    public EvaluationConverter(EvaluationRepository evaluationRepository, UserRepository userRepository, BookRepository bookRepository, WriterRepository writerRepository) {
        this.evaluationRepository = evaluationRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.writerRepository = writerRepository;
    }

    public List<EvaluationDto> convertTolistEvaluationToEvaluationDto(@NotNull List<Evaluation> from){

        List<EvaluationDto> newItems = new ArrayList<>();

        for(Evaluation evaluation :from){

            EvaluationDto responseItem = new EvaluationDto();

            if(evaluation.isBookEvaluation()) {
                Book book = bookRepository.findById(evaluation.getBook().getId()).get();
                responseItem.setBookId(book.getId());
                responseItem.setUserName(hideName(evaluation.getUser()));
                responseItem.setRating(evaluation.getRating());
                responseItem.setMassage(evaluation.getMassage());
                responseItem.setBookEvaluation(true);
              newItems.add(responseItem);

            }
            else if(!evaluation.isBookEvaluation()){

                Writer writer = writerRepository.findById(evaluation.getWriter().getId()).get();
                responseItem.setWriterId(writer.getId());
                responseItem.setUserName(hideName(evaluation.getUser()));
                responseItem.setRating(evaluation.getRating());
                responseItem.setMassage(evaluation.getMassage());
                responseItem.setBookEvaluation(false);
              newItems.add(responseItem);

            }

        }
        return newItems;
    }
    public EvaluationDto convertEvaluationtoEvaluationDto(Evaluation evaluation){

        EvaluationDto responseItem = new EvaluationDto();

        if(evaluation.isBookEvaluation()) {
            Book book = bookRepository.findById(evaluation.getBook().getId()).get();
            responseItem.setBookId(book.getId());
            responseItem.setUserName(hideName(evaluation.getUser()));
            responseItem.setRating(evaluation.getRating());
            responseItem.setMassage(evaluation.getMassage());
            responseItem.setBookEvaluation(true);
            return responseItem;

        }
        else if(!evaluation.isBookEvaluation()){

            Writer writer = writerRepository.findById(evaluation.getWriter().getId()).get();
            responseItem.setWriterId(writer.getId());
            responseItem.setUserName(hideName(evaluation.getUser()));
            responseItem.setRating(evaluation.getRating());
            responseItem.setMassage(evaluation.getMassage());
            responseItem.setBookEvaluation(false);
            return responseItem;

        }
        return null ;
    }

    public Evaluation convertEvaluationRequestToEvaluation(EvaluationRequest evaluationRequest){

        User user = userRepository.findByEmail(evaluationRequest.getUserEmail()).orElseThrow(()-> new EntityNotFoundException("User not found with this id"));

        if(evaluationRequest.isBookEvaluation()){
            Evaluation bookEvaluation = new Evaluation();

            bookEvaluation.setBookEvaluation(true);
            Book book =bookRepository.findById(evaluationRequest.getBookId()).get();
            bookEvaluation.setBook(book);
            bookEvaluation.setRating(evaluationRequest.getRating());
            bookEvaluation.setMassage(evaluationRequest.getMessage());
            bookEvaluation.setCreationDate(LocalDateTime.now());
            bookEvaluation.setUser(user);
            evaluationRepository.save(bookEvaluation);

            return bookEvaluation;

        }else if(!evaluationRequest.isBookEvaluation()){

            Evaluation writerEvaluation = new Evaluation();
            writerEvaluation.setBookEvaluation(false);

            Writer writer = writerRepository.findById(evaluationRequest.getWriterId()).get();
            writerEvaluation.setWriter(writer);
            writerEvaluation.setRating(evaluationRequest.getRating());
            writerEvaluation.setMassage(evaluationRequest.getMessage());
            writerEvaluation.setCreationDate(LocalDateTime.now());
            writerEvaluation.setUser(user);
            evaluationRepository.save(writerEvaluation);

            return writerEvaluation;
        }
        return null;

    }

    private String hideName(User user){

        String name = user.getName();
        char name2=  name.charAt(0);
        String surname = user.getSurname();
        char surname2= surname.charAt(0);

        String hidedName=name2 +"****"+surname2+"****" ;
        return hidedName ;

    }


}
