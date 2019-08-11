package com.example.service;

import com.example.model.Users;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    public String login(String userId, String userPw) {
        if (userId.equals("") || userPw.equals("")) {
            return "login";
        }

        Users users = (userRepository.findByUseridAndUserpw(userId, userPw));
        if (users == null) {
            return "login";
        }
        session.setAttribute("loginUser", users);
        return "index";

    }
}

