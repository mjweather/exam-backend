package com.example.examangular.repo;

import com.example.examangular.model.exam.Question;
import com.example.examangular.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    public Set<Question> findByQuiz(Quiz quiz);
}
