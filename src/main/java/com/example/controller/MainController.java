package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }


    @RequestMapping(value = "/joinPage")
    public String joinPage(){
        return "join";
    }

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        session.invalidate();
        return "index";
    }
    @RequestMapping("/freeboarWritePage")
    public String freeboardWrite(){
        return "freeboardWrite";
    }
}
