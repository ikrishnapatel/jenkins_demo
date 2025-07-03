package com.springk.apidemos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springk.apidemos.Dao.User;
import com.springk.apidemos.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    public User getUserByEmail(String email)
    {
        return userRepository.getUserByEmail(email);
    }

    public User getUserById(int userid)
    {
        return userRepository.getUserById(userid);
    }


    public String addUserDetails(User user) {
        userRepository.save(user);
        return "saved";
    }

    
}
