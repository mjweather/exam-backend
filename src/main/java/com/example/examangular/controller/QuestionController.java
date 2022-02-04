package com.example.examangular.controller;

import com.example.examangular.model.exam.Question;
import com.example.examangular.model.exam.Quiz;
import com.example.examangular.service.QuestionService;
import com.example.examangular.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{qId}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qId") Long qId){
        Quiz quiz = this.quizService.getQuiz(qId);
        Set<Question> questions = quiz.getQuestions();
        List list=new ArrayList(questions);
        int size=Integer.parseInt(quiz.getNumberOfQuestions());
        if(list.size()>size){
            list= list.subList(0,size+1);
            Collections.shuffle(list);
            return ResponseEntity.ok(list);
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable("quesId")Long quesId){
        return this.questionService.getQuestion(quesId);
    }
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getAllQuestion(@PathVariable("qid") Long qid){
        Quiz quiz=new Quiz();
        quiz.setQid(qid);

        Set<Question> questionsofQuiz = this.questionService.getQuestionsofQuiz(quiz);
        System.out.println(questionsofQuiz+" id:"+qid);
        return  ResponseEntity.ok(questionsofQuiz);
    }
    @DeleteMapping("/{qId}")
    public void deleteQuestion(@PathVariable("qId")Long qId){
        this.questionService.deleteQuestion(qId);
    }
}
