package com.example.demo.controller;

import com.example.demo.model.user.employeeDto;
import com.example.demo.paging.Criteria;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.SkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //    사원 리스트
    @GetMapping(value = "/employee/list")
    public String openEmployeeList(@ModelAttribute("params") employeeDto params, Model model) {
        List<employeeDto> employeeList = employeeService.getEmployeeList(params);
        model.addAttribute("employeeList", employeeList);

        return "employeeList";
    }

    @GetMapping("/cc")
    public String cc(@ModelAttribute("params") employeeDto params, Model model) {
        List<employeeDto> employeeList = employeeService.getEmployeeList(params);
        model.addAttribute("employeeList", employeeList);

        return "insertProEmpl";
    }


    //    사원
    @GetMapping(value = "/employee")
    public String openEmployee(Model model) {

        return "/employee";
    }
}
