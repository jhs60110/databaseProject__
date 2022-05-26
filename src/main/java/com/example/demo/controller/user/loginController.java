package com.example.demo.controller.user;
import com.example.demo.model.user.User;
import com.example.demo.service.security.UserDetailServiceImp;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class loginController {
    private static UserDetailServiceImp userDetailServiceImp;
    private Logger logger = LoggerFactory.getLogger(loginController.class);
    @PostMapping("/signIn")
    public String login(Model model, String id) {

        User user = (User) userDetailServiceImp.loadUserByUsername(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            User userRole = (User) authentication.getPrincipal();
        }
        model.addAttribute("LoginErrorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
        logger.info("Login id : {}", user.getId());

        return "signIn";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }
}
