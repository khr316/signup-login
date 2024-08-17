package com.example.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sign.dao.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @GetMapping("signup")
    public String signup(){
        return "user/signup";
    }
    @GetMapping("login")
    public String login(){
        return "user/login";
    }

    @PostMapping("signup")
    public String signup(@RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password,
                         Model model){
        userDao.insertSignup(username,email,password);
        return "redirect:/login";
    }


    @PostMapping("login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpSession session){
        int userCnt = userDao.selectCntUser(email,password);
        if (userCnt > 0){
            session.setAttribute("email", email);
            return "redirect:/main";
        }
        else {
            model.addAttribute("error", "이메일 또는 비밀번호를 확인하세요");
            return "user/login";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }

    @PostMapping("check-email")
    @ResponseBody
    public boolean checkEmail(@RequestParam String email) {
        return userDao.isEmailExists(email);
    }

    @GetMapping("main")
    public String main(){
        return "main";
    }
    
    
}
