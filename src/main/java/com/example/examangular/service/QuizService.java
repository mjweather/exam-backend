package com.example.examangular.service;

import com.example.examangular.model.exam.Quiz;

import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizes();
    public Quiz getQuiz(Long qId);
    public void deleteQuiz(Long qId);
}
