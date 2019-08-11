package com.example.service;

import com.example.model.Users;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    public String joinUser(String userId, String userPw, String userName){

        if (userId.equals("") || userPw.equals("") || userName.equals("")){
            return "join";
        }

        Users users = new Users();
        users.setUserid(userId);
        users.setUserpw(userPw);
        users.setUsername(userName);

        userRepository.save(users);
        return "index";
    }
}
