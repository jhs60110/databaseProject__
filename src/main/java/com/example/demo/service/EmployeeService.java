package com.example.demo.service;

import com.example.demo.model.user.employeeDto;
import com.example.demo.paging.Criteria;


import java.util.List;

public interface EmployeeService {
    //  이름으로 employee 검색
    public employeeDto getEmployeeInfo(String e_name);

    //  모든 employee 조회
    public List<employeeDto> getEmployeeList(employeeDto params);
}