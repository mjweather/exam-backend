package com.example.examangular;

import com.example.examangular.model.Role;
import com.example.examangular.model.User;
import com.example.examangular.model.UserRole;
import com.example.examangular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamAngularApplication.class, args);
    }
    
}
