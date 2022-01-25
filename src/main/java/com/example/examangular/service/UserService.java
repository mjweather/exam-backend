package com.example.examangular.service;

import com.example.examangular.model.User;
import com.example.examangular.model.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String userName);
    public void deleteuser(Long Id);
    public User updateUser(User user);
}
