package com.example.demo.controller.user;

import com.example.demo.model.user.CareerDto;
import com.example.demo.model.user.SkillSetDto;
import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import com.example.demo.service.CareerService;
import com.example.demo.service.SkillSetService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private static UserService userService;
    private static UserDetailServiceImp userDetailServiceImp;

    @Autowired
    private SkillSetService skillSetService;

    @Autowired
    private CareerService careerService;

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
        if (authentication != null) {
            User userRole = (User) authentication.getPrincipal();
            logger.info("Login id signIn : {}", authentication);
        } else {
            logger.info("signIn : authentication NULL");
            String errorMsg = "아이디 또는 비밀번호가 일치하지 않습니다.";
            model.addAttribute("LoginErrorMessage", errorMsg);
        }

        logger.info("Login id : {}", user.getId());
        logger.info("Login username : {}", user.getUsername());

        return "/signIn";
    }
    @PostMapping("/main")
    public String loginSuccess(Model model, String id) {
        logger.info("로그인성공 메인으로 돌아감");
        User user = (User) userDetailServiceImp.loadUserByUsername(id);
        return "redirect:/main";
    }

    @GetMapping("/myPage")
    public String myPage(Model model, String id) {
        logger.info("마이페이지");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String userName = user.getE_name();
        String userEid = user.getE_id().toString();
        logger.info("userEid {}", userEid);
        logger.info("userName {}", userName);
        employeeDto employeeDto = userService.getUserInfo(userEid);
        model.addAttribute("user", employeeDto);
//        SkillSetDto skillSetDto = skillSetService.getSkillSetInfo(userEid);
//        직원 기술
        List<SkillSetDto> skillSetDtoList = skillSetService.getSkillSetInfo(userEid);

        model.addAttribute("skillSet", skillSetDtoList);
        logger.info("skillSet {}", skillSetDtoList);

        List<String> languageList = new ArrayList<>();
        for(SkillSetDto skillSetDto: skillSetDtoList){
            if (!skillSetDto.getS_language().equals("")) {
                logger.info(skillSetDto.getS_language());
                languageList.add(skillSetDto.getS_language());
            }
        }
        model.addAttribute("languageList", languageList);

        List<String> frameworkList = new ArrayList<>();
        for(SkillSetDto skillSetDto: skillSetDtoList){
            if (!skillSetDto.getS_framework().equals("")) {
                frameworkList.add(skillSetDto.getS_framework());
            }
        }
        model.addAttribute("frameworkList", frameworkList);

        //        직원 경력
        List<CareerDto> CareerDtoList = careerService.getCareerInfo(userEid);

        model.addAttribute("career", CareerDtoList);
        logger.info("career {}", CareerDtoList);

        List<String> caNameList = new ArrayList<>();
        for(CareerDto careerDto: CareerDtoList){
            if (!careerDto.getCa_name().equals("")) {
                logger.info(careerDto.getCa_name());
                caNameList.add(careerDto.getCa_name());
            }
        }
        model.addAttribute("caNameList", caNameList);

        List<String> caDescList = new ArrayList<>();
        for(CareerDto careerDto: CareerDtoList){
            if (!careerDto.getCa_description().equals("")) {
                logger.info(careerDto.getCa_description());
                caDescList.add(careerDto.getCa_description());
            }
        }
        model.addAttribute("caDescList", caDescList);

        return "user/myPage";
    }
    @GetMapping("/editMyPage")
    public String editMyPage (Model model) {
        logger.info("마이페이지 수정");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String userName = user.getE_name();
        String userEid = user.getE_id().toString();
        logger.info("userEid {}", userEid);
        logger.info("userName {}", userName);
        employeeDto employeeDto = userService.getUserInfo(userEid);
        model.addAttribute("user", employeeDto);
//        SkillSetDto skillSetDto = skillSetService.getSkillSetInfo(userEid);

//        직원 기술
        List<SkillSetDto> skillSetDtoList = skillSetService.getSkillSetInfo(userEid);
        logger.info("skillSet {}", skillSetDtoList);
        model.addAttribute("skillSet", skillSetDtoList);

        List<String> languageList = new ArrayList<>();
        for(SkillSetDto skillSetDto: skillSetDtoList){
            if (!skillSetDto.getS_language().equals("")) {
                languageList.add(skillSetDto.getS_language());
            }
        }
        model.addAttribute("languageList", languageList);

        List<String> frameworkList = new ArrayList<>();
        for(SkillSetDto skillSetDto: skillSetDtoList){
            if (!skillSetDto.getS_framework().equals("")) {
                frameworkList.add(skillSetDto.getS_framework());
            }
        }
        model.addAttribute("frameworkList", frameworkList);

        //        직원 경력
        List<CareerDto> CareerDtoList = careerService.getCareerInfo(userEid);

        model.addAttribute("career", CareerDtoList);
        logger.info("career {}", CareerDtoList);

        List<String> caNameList = new ArrayList<>();
        for(CareerDto careerDto: CareerDtoList){
            if (!careerDto.getCa_name().equals("")) {
                logger.info(careerDto.getCa_name());
                caNameList.add(careerDto.getCa_name());
            }
        }
        model.addAttribute("caNameList", caNameList);

        List<String> caDescList = new ArrayList<>();
        for(CareerDto careerDto: CareerDtoList){
            if (!careerDto.getCa_description().equals("")) {
                logger.info(careerDto.getCa_description());
                caDescList.add(careerDto.getCa_description());
            }
        }
        model.addAttribute("caDescList", caDescList);

        return "user/editMyPage";
    }

    @PostMapping("/editMyPage")
    public String editMyPage (employeeDto employeeDto) {
        userService.updateUserInfo(employeeDto);
        logger.info("framework: {}", employeeDto.getS_framework());
        logger.info("language: {}", employeeDto.getS_language());

        List<String> languageList = Arrays.asList(employeeDto.getS_language().split(", "));
        List<String> frameworkList = Arrays.asList(employeeDto.getS_framework().split(", "));

        userService.updateSkillSet(languageList, frameworkList, employeeDto.getE_id());

        List<String> caNameList = Arrays.asList(employeeDto.getCa_name().split(", "));
        List<String> caDescList = Arrays.asList(employeeDto.getCa_description().split(", "));

        userService.updateCareer(caNameList, caDescList, employeeDto.getE_id());

        logger.info("마이페이지 수정 완료");

        return "redirect:/user/myPage";
    }
}
