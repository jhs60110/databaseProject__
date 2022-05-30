package com.example.demo.controller.project;

import com.example.demo.model.project.Participant;
import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.project.ProjectTDescr;
import com.example.demo.model.project.inparticipa;
import com.example.demo.model.user.CareerDto;
import com.example.demo.model.user.SkillSetDto;
import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import com.example.demo.service.CareerService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.SkillSetService;
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

import java.util.ArrayList;
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
    @Autowired
    private SkillSetService skillSetService;

    @Autowired
    private CareerService careerService;
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
    public String projectDescriptionPage(Model model, @PathVariable String pr_id, @ModelAttribute("params") ProjectDescr params, @ModelAttribute("") Participant push_pr_id) {

        List<Participant> emplInProject = ProjectService.getEmplInProject(push_pr_id);
        model.addAttribute("emplInProject", emplInProject);

        List<ProjectDescr> AProject = ProjectService.getAProject(params);
        model.addAttribute("AProject", AProject);
//
//        List<ProjectTDescr> ATProject = ProjectTService.getATProject(Tparams);
//        model.addAttribute("ATProject", ATProject);


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

        ProjectDescr aProject = AProject.get(0);
        String startDate = aProject.getPr_start_date();
        String endDate = aProject.getPr_end_date();

        model.addAttribute("AProject", AProject);
        model.addAttribute("pr_id", pr_id);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);


        return "project/projectEmploAppend";
    }
    @PostMapping(value = "/projectEmploAppend/{pr_id}")


//    public String projectEmploAppenda(@RequestBody inparticipa requestDto) {
//
//        inparticipa inparticipa = SProjectEmplInsertService.projectEmpInsert(requestDto);
//
//        return "project/projectEmploAppend";
//    }




    public String insertParticipant(Participant participant, @PathVariable String pr_id) {
        participant.setPr_id(pr_id);
        projectService.insertParticipant(participant);
        logger.info("new member added!!");
        return "redirect:/project/projectDescription/" + pr_id;
    }

    @GetMapping(value = "/projectUpdate/{pr_id}")
    public String updateProject(Model model, @PathVariable String pr_id) {
        ProjectDescr projectDescr = projectService.getProjectById(pr_id);
        model.addAttribute("projectDescr", projectDescr);
        return "project/projectUpdate";
    }

    @PostMapping(value = "/projectUpdate/{pr_id}")
    public String updateProject(ProjectDescr projectDescr, @PathVariable String pr_id){
        projectService.updateProject(projectDescr);
        return "redirect:/main";
    }

}

