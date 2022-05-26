package com.example.demo.service;

import com.example.demo.mapper.user.UserMapper;
import com.example.demo.model.user.employeeDto;

import com.example.demo.paging.Criteria;

import com.example.demo.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServicelmpl implements EmployeeService{
    @Autowired
    private UserMapper userMapper;

//  이름으로 employee 검색
    @Override
    public employeeDto getEmployeeInfo(String e_name) {
        return userMapper.getEmployeeInfo(e_name);

    }

//  모든 employee 조회
    @Override
    public List<employeeDto> getEmployeeList(employeeDto params) {
        List<employeeDto> employeeList = Collections.emptyList();
        int employeeTotalCount = userMapper.getEmployeeTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(employeeTotalCount);

        params.setPaginationInfo(paginationInfo);
        if (employeeTotalCount > 0) {
            employeeList = userMapper.getEmployeeList(params);
        }
        return employeeList;
    }

}
