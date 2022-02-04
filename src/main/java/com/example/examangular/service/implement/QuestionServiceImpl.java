package com.example.examangular.service.implement;

import com.example.examangular.model.exam.Question;
import com.example.examangular.model.exam.Quiz;
import com.example.examangular.repo.QuestionRepository;
import com.example.examangular.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long qId) {
        return this.questionRepository.findById(qId).get();
    }

    @Override
    public void deleteQuestion(Long qId) {
        Question question= new Question();
        question.setQuesId(qId);
        this.questionRepository.delete(question);
    }

    @Override
    public Set<Question> getQuestionsofQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }
}
