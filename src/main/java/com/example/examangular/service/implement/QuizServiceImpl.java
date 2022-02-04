package com.example.examangular.service.implement;

import com.example.examangular.model.exam.Quiz;
import com.example.examangular.repo.QuizRrepository;
import com.example.examangular.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRrepository quizRrepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRrepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRrepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new HashSet<>(this.quizRrepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long qId) {
        return this.quizRrepository.findById(qId).get();
    }

    @Override
    public void deleteQuiz(Long qId) {
    Quiz quiz=new Quiz();
    quiz.setQid(qId);
    this.quizRrepository.delete(quiz);
    }
}
