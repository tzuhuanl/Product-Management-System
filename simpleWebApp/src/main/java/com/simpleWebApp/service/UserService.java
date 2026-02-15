package com.simpleWebApp.service;


import com.simpleWebApp.model.Users;
import com.simpleWebApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users register(Users user){
        return userRepo.save(user);

    }

}
