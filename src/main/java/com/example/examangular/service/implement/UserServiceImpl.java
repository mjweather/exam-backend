package com.example.examangular.service.implement;

import com.example.examangular.model.User;
import com.example.examangular.model.UserRole;
import com.example.examangular.repo.RoleRepository;
import com.example.examangular.repo.UserRepository;
import com.example.examangular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        System.out.println(user.getUserName());
        User local=this.userRepository.findByUserName(user.getUserName());

        //checking whether already exists or not
        if (local!=null){
            System.out.println("User already exists");
            throw new Exception("User already exists");
        }else{
          //creating new user
          for (UserRole ur : userRoles){
              roleRepository.save(ur.getRole());
          }
          user.getUserRoles().addAll(userRoles);
            local=userRepository.save(user);
         }

        return local;
    }


    public User getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public void deleteuser(Long Id) {
        this.userRepository.deleteById(Id);
    }

    @Override
    public User updateUser(User user) {
        this.userRepository.save(user);
        return null;
    }
}
