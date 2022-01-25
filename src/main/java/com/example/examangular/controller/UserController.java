package com.example.examangular.controller;

import com.example.examangular.model.Role;
import com.example.examangular.model.User;
import com.example.examangular.model.UserRole;
import com.example.examangular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");
        System.out.println(user.getUserName());
        Set<UserRole> roles=new HashSet<>();

        Role role=new Role();
        role.setRoleName("NORMAL");
        role.setRoleId(45L);

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user,roles);

    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteuser(userId);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
       return this.userService.updateUser(user);
    }
}
