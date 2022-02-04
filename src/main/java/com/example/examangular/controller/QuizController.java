package com.example.examangular.controller;

import com.example.examangular.model.exam.Quiz;
import com.example.examangular.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return  ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }
    @GetMapping("/")
    public ResponseEntity<?> getQuizes(){
        return ResponseEntity.ok(this.quizService.getQuizes());
    }
    @GetMapping("/{qId}")
    public Quiz getQuiz(@PathVariable("qId") Long qId){
        return this.quizService.getQuiz(qId);
    }
    @DeleteMapping("/{qId}")
    public void deleteQuiz(@PathVariable("qId")Long qId){
        this.quizService.deleteQuiz(qId);
    }
}
