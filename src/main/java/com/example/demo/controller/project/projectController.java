package com.example.demo.controller.project;

import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.project.ProjectTDescr;
import com.example.demo.model.user.User;
import com.example.demo.service.project.ProjectService;
import com.example.demo.service.project.ProjectTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/project")
public class projectController {
    private Logger logger = LoggerFactory.getLogger(projectController.class);
    private static ProjectService projectService;
    private static ProjectTService projectTService;

    @Autowired
    public projectController(ProjectService projectService, ProjectTService projectTService) {
        this.projectService = projectService;
        this.projectTService = projectTService;
    }

    @GetMapping("/projectShow")
    public String project(@ModelAttribute("params") ProjectDescr params,  Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String userRole = user.getRole();
        logger.info("userRole {}", userRole);
        model.addAttribute("userRole", userRole);

        List<ProjectDescr> Project = projectService.selectNTProject(params);

        model.addAttribute("ProjectDe", Project);


        return "/project/projectShow";
    }

    @PostMapping("/insert")
    public String projectInsert(ProjectDescr projectDescr) {
        ProjectService.createProject(projectDescr);
        System.out.println(projectDescr);

        return "redirect:/";
    }

    @GetMapping("/projectInsert")
    public String projectInsertPage(Model model) {
//        logger.info("ProjectDe:{}", Project);
        return "/project/projectInsert";
    }

    @GetMapping("/projectTermination")
    public String projectTermination(Model model) {
//        String userRole = user.getRole();
//        model.addAttribute("userRole", userRole);



        List<ProjectTDescr> ProjectT = projectTService.selectTProject();

        model.addAttribute("ProjectDeT", ProjectT);
        return "/project/projectTermination";
    }
}
