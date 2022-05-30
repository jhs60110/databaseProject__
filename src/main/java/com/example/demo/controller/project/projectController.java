package com.example.demo.controller.project;

import com.example.demo.model.project.Participant;
import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.project.ProjectTDescr;
import com.example.demo.model.project.inparticipa;
import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.project.ProjectService;
import com.example.demo.service.project.ProjectTService;
import com.example.demo.service.project.SProjectEmplInsertService;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/project")
public class projectController {
    private final EmployeeService employeeService;
    private Logger logger = LoggerFactory.getLogger(projectController.class);
    private static ProjectService projectService;
    private static ProjectTService projectTService;

    @Autowired
    public projectController(ProjectService projectService, ProjectTService projectTService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.projectTService = projectTService;
        this.employeeService = employeeService;
    }

    @GetMapping("/projectShow")
    public String project(@ModelAttribute("params") ProjectDescr params, Model model) {

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

    @PostMapping("/projectInsert")
//    @RequestMapping(value="/projectInsert", method=RequestMethod.POST)
    public String projectInsertPage(Model model, @ModelAttribute("participain") employeeDto participain) {
        employeeDto employeeDto = UserService.getUserInfo(String.valueOf(participain));
        logger.info("employeeDto: {}", employeeDto);
        model.addAttribute("employeeDto", employeeDto);

        return "project/projectInsert";
    }

    @GetMapping("/projectInsert")
//    @RequestMapping(value="/projectInsert", method=RequestMethod.POST)
    public String projectInsertPage0(Model model, @ModelAttribute("participain") employeeDto participain) {
        employeeDto employeeDto = UserService.getUserInfo(String.valueOf(participain));
        logger.info("employeeDto: {}", employeeDto);
        model.addAttribute("employeeDto", employeeDto);

        return "project/projectInsert";
    }

    @GetMapping("/projectTermination")
    public String successLogin(@ModelAttribute("params") ProjectDescr params, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String userName = user.getE_name();
        logger.info("userName {}", userName);
        model.addAttribute("userName", userName);

        String userRole = user.getRole();
        model.addAttribute("userRole", userRole);


        List<ProjectDescr> Project = projectService.getProjectTList(params);

        model.addAttribute("ProjectDeT", Project);

        return "project/projectTermination";
    }

    @GetMapping("/projectDescription/{pr_id}")
    public String projectDescriptionPage(Model model, @PathVariable String pr_id, @ModelAttribute("params") ProjectDescr params, @ModelAttribute("push_pr_id") Participant push_pr_id) {

        List<Participant> emplInProject = ProjectService.getEmplInProject(push_pr_id);
        model.addAttribute("emplInProject", emplInProject);

        List<ProjectDescr> AProject = ProjectService.getAProject(params);
        model.addAttribute("AProject", AProject);

        return "project/projectDescription";
    }

    @GetMapping("/projectTDescription/{pr_id}")
    public String projectTDescriptionPage(Model model, @PathVariable String pr_id, @ModelAttribute("params") ProjectTDescr params, @ModelAttribute("push_pr_id") Participant push_pr_id) {

        List<Participant> emplInProject = ProjectService.getEmplInProject(push_pr_id);
        model.addAttribute("emplInProject", emplInProject);

        List<ProjectTDescr> ATProject = ProjectTService.getATProject(params);
        model.addAttribute("ATProject", ATProject);

        return "project/projectTDescription";
    }


    @GetMapping(value = "/employee/list")
    public String openEmployeeList(@ModelAttribute("params") employeeDto params, Model model) {
        List<employeeDto> employeeList = employeeService.getEmployeeList(params);
        model.addAttribute("employeeList", employeeList);


        return "popUpMakeProjectEmployeeList";
    }


    @GetMapping(value = "/projectEmploAppend/{pr_id}")
    public String projectEmploAppend(Model model, @PathVariable String pr_id, @ModelAttribute("params") ProjectDescr params) {
        List<ProjectDescr> AProject = ProjectService.getAProject(params);
        model.addAttribute("AProject", AProject);


        return "project/projectEmploAppend";
    }
    @PostMapping(value = "/projectEmploAppend/{pr_id}")
    public String projectEmploAppenda(@RequestBody inparticipa requestDto) {


        inparticipa inparticipa = SProjectEmplInsertService.projectEmpInsert(requestDto);



        return "project/projectEmploAppend";
    }

}
