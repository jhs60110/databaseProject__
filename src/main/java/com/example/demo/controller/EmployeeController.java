package com.example.demo.controller;

import com.example.demo.controller.user.UserController;
import com.example.demo.model.user.CareerDto;
import com.example.demo.model.user.SkillSetDto;
import com.example.demo.model.user.employeeDto;
import com.example.demo.service.CareerService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.SkillSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SkillSetService skillSetService;
    @Autowired
    private CareerService careerService;
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


//    //    사원
//    @GetMapping(value = "/employee")
//    public String openEmployee(Model model) {
//
//        return "employeeDescrip";
//    }


    // 여기가 그 뭐냐 그 사원 기술스택 확인페이지임
    @GetMapping("/employeeDescrip/{e_id}")
    public String myPage(Model model ,@ModelAttribute("e_id") String e_id ) {
//        뭐 뭐 들어가야하지? 사원 e_id 받은거 넘겨서 출력된 거 model.addatr

        logger.info("e_id!!!!!!!!!!!!!!!!! {}", e_id);




        List<CareerDto> CareerDtoList = careerService.getCareerInfo(e_id);
        model.addAttribute("Career", CareerDtoList);
        logger.info("CareerDtoList!!!!!!!!!!!!!!!!! {}", CareerDtoList);

        List<SkillSetDto> SkillSetDtoList =  skillSetService.getSkillSetInfo(e_id);
        model.addAttribute("SkillSet", SkillSetDtoList);
        logger.info("SkillSetDtoList!!!!!!!!!!!!!!!!! {}", SkillSetDtoList);

        return "employeeDescrip";
    }
}
