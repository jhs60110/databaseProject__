package com.example.demo.controller;

import com.example.demo.mapper.project.ProjectTMapper;
import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.project.ProjectTDescr;
import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import com.example.demo.service.SkillSetService;
import com.example.demo.service.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.service.EmployeeService;
import java.util.List;

@Controller
public class mainController {
    private static UserService userService;
    private static final Logger logger = LoggerFactory.getLogger("MainController");
    private ProjectService projectService;
    private ProjectTMapper projectTService;
    private EmployeeService employeeService;
    @Autowired
    public mainController(ProjectService projectService, ProjectTMapper projectTService) {
        this.projectService = projectService;
        this.projectTService =  projectTService;
    }
    @GetMapping("/")
    public String index(Model model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            logger.info("user : " + user);
            for (GrantedAuthority auth : user.getAuthorities()) {
                logger.info("ROLE : " + auth.getAuthority());
                if (auth.getAuthority().equals("ROLE_2")) {
                    return "redirect:/main"; // TODO 관리자용 navbar로 변경
                } else if (auth.getAuthority().equals("ROLE_1")) {
                    return "redirect:/main";
                }
                request.getSession().setMaxInactiveInterval(60 * 60 * 24);
            }
        }
//        model.addAttribute("checkUserYN", "N");
        return "/signIn";
    }


    @GetMapping("/signIn")
    public String signIn (Model model) {
        logger.info("로그인페이지이동");
        return "signIn";
    }


    @GetMapping("/main")
    public String successLogin(@ModelAttribute("params") ProjectDescr params, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String userName = user.getE_name();
        logger.info("userName {}", userName);
        model.addAttribute("userName", userName);

        String userRole = user.getRole();
        model.addAttribute("userRole", userRole);


        List<ProjectDescr> Project = projectService.getProjectList(params);

        model.addAttribute("ProjectDe", Project);

        return "project/projectShow";
    }


    @GetMapping("/signUp")
    public String signUp (Model model) {
        logger.info("회원가입페이지이동");
        return "signUp";
    }
    @GetMapping("/newmain")
    public String newMain (Model model) {
        logger.info("뉴메이동");
        return "newmain";
    }



    @GetMapping("/myPage")
    public String myPage(Model model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        logger.info("마이페이지");

        User user = null;
        if (authentication != null) {
            user = (User) authentication.getPrincipal();
            logger.info("user : " + user);

        } else {
            logger.info("check null");
        }
        String userName = user.getE_name();
        model.addAttribute("userName", userName);

        return "myPage";
    }
}
