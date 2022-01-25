package com.example.examangular.repo;

import com.example.examangular.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   public User findByUserName(String userName);
}