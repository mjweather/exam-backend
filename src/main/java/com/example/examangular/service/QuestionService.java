package com.example.examangular.service;

import com.example.examangular.model.exam.Question;
import com.example.examangular.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long qId);
    public void deleteQuestion(Long qId);
    public Set<Question> getQuestionsofQuiz(Quiz quiz);
}
