package com.example.examangular.repo;

import com.example.examangular.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRrepository extends JpaRepository<Quiz,Long> {
}
