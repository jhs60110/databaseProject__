package com.example.demo.controller.user;

import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import com.example.demo.service.user.UserService;
//import org.mybatis.logging.Logger;
//import org.mybatis.logging.LoggerFactory;

import com.example.demo.service.security.UserDetailServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private static UserService userService;
    private static UserDetailServiceImp userDetailServiceImp;
//<<<<<<< HEAD
//    //  private static EstimateService estimateService;
//=======
//>>>>>>> c7f07dcced6e59cf813cc75cf88c5b129d8fd97c

    @Autowired
    public UserController(UserService userService,
                          UserDetailServiceImp userDetailServiceImp) {
        this.userService = userService;
        this.userDetailServiceImp = userDetailServiceImp;
    }

    @PostMapping("/save")
    public String create(employeeDto employeeDTO) {
        UserService.createUser(employeeDTO);
        System.out.println(employeeDTO);
        return "redirect:/";
    }


    //        로그인
    @PostMapping("/signIn")
    public String signin(Model model, String id) {
        User user = (User) userDetailServiceImp.loadUserByUsername(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//<<<<<<< HEAD
//        if(authentication!=null){
//            User userRole = (User) authentication.getPrincipal();
//
//            logger.info("Login id signIn : {}", authentication);
//        }else{
//            logger.info("signIn : authentication NULL" );
//=======
        if (authentication != null) {
            User userRole = (User) authentication.getPrincipal();

            logger.info("Login id signIn : {}", authentication);
        } else {
            logger.info("signIn : authentication NULL");
//>>>>>>> c7f07dcced6e59cf813cc75cf88c5b129d8fd97c
        }
        model.addAttribute("LoginErrorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
        logger.info("Login id : {}", user.getId());
        logger.info("Login username : {}", user.getUsername());

        return "/signIn";
    }
    //<<<<<<< HEAD
//    //메인페이지 이동(로그인 성공 시 메인페이지로 이동)
////    @PostMapping("/main")
////    public String loginSuccess(Model model, @PathVariable String id) {
////        employeeDto userInfo = userService.getUserInfo(id);
////        model.addAttribute("userInfo", userInfo);
////      //  User user = (User) userDetailServiceImp.loadUserByUsername(emailAddress);
////        return "redirect:/main";
////    }
//=======
//
//>>>>>>> c7f07dcced6e59cf813cc75cf88c5b129d8fd97c
    @PostMapping("/main")
    public String loginSuccess(Model model, String id) {
        logger.info("로그인성공 메인으로 돌아감");
        User user = (User) userDetailServiceImp.loadUserByUsername(id);
        return "redirect:/main";
    }
//<<<<<<< HEAD
//
////        userService.createUser(requestDto);
////        if (requestDto.getSuccessYN().equals("Y")) {
////            logger.debug("errorMessage : {}", requestDto.getErrorMessage());
////            return "redirect:/login";
////        } else {
////            logger.debug("errorMessage : {}", requestDto.getErrorMessage());
////            model.addAttribute("checkEmailDup", "이미 가입된 이메일입니다.");
////            return "/auth/signUp";
////        }
//
//}
//=======

    @GetMapping("/myPage")
    public String myPage(Model model, String id) {
        logger.info("마이페이지");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String userName = user.getE_name();
        Long userEid = user.getE_id();
        logger.info("userEid {}", userEid);
        logger.info("userName {}", userName);
        model.addAttribute("userName", userName);
        model.addAttribute("userEid", userEid);
        model.addAttribute("user", user);
//        User user = (User) userDetailServiceImp.loadUserByUsername(id);

        return "user/myPage";
    }
    @GetMapping("/editMyPage")
    public String editMyPage () {
        logger.info("마이페이지 수정");
        return "user/editMyPage";
    }
}


//>>>>>>> c7f07dcced6e59cf813cc75cf88c5b129d8fd97c
