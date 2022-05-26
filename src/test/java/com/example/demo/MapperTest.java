package com.example.demo;

//import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.user.UserMapper;
//import com.example.demo.model.EmployeeDTO;
import com.example.demo.model.user.employeeDto;
import com.example.demo.paging.Criteria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    // employee 생성 테스트
    @Test
    public void testOfCreateUser() {
        employeeDto params = new employeeDto();

        params.setE_name("test4");
        params.setResidentNum("111111-2222222");
        params.academic_level("명지대");

        params.setRole("2");
        params.setId("9999");
        params.setPassword("8888");
        params.setDepartment("11");

        userMapper.createUser(params);
        System.out.println("직원 생성 성공!");
    }

    // employee 조회 테스트(id, password, department는 가져와지지만 나머지가 null임)
    @Test
    public void testOfGetUserInfo() {
        System.out.println("start test");
        employeeDto employee = userMapper.getUserInfo((String) "9999");
        System.out.println(employee);
        try {
            String employeeJson = new ObjectMapper().writeValueAsString(employee);
            System.out.println("==================");
            System.out.println(employeeJson);
            System.out.println("==================");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOfGetEmployeeInfo() {
        System.out.println("start test");
        employeeDto employee = userMapper.getEmployeeInfo((String) "test3");
        System.out.println(employee);
        try {
            String employeeJson = new ObjectMapper().writeValueAsString(employee);
            System.out.println("==================");
            System.out.println(employeeJson);
            System.out.println("==================");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

//    전체 employee list 받아오는 test
    @Test
    public void testOfGetEmployeeTotalCount() {

        Object criteria = null;

        int employeeTotalCount = userMapper.getEmployeeTotalCount((Criteria) criteria);
        if (employeeTotalCount > 0) {
            List<employeeDto> employeeDtoList = userMapper.getEmployeeList((Criteria) criteria);
            if(CollectionUtils.isEmpty(employeeDtoList) == false){
                for (employeeDto employee : employeeDtoList) {
                    System.out.println("==================");

                    System.out.println(employee.getid());
                    System.out.println(employee.gete_name());

                    System.out.println(employee.getResidentNum());
                    System.out.println(employee.getRole());
                    System.out.println(employee.getId());
                    System.out.println(employee.getPassword());
                    System.out.println(employee.getDepartment());
                    System.out.println("=================");
                }
            }
        }
    }
<<<<<<< HEAD
//    @Autowired
//    private EmployeeMapper employeeMapper;
//    @Test
//    public void testOfSelectEmployeeDetail() {
//        System.out.println("start test");
//        EmployeeDTO employeeDTO = employeeMapper.selectEmployeeDetail((long) 1);
//        System.out.println(employeeDTO);
//        try {
//            String employeeJson = new ObjectMapper().writeValueAsString(employeeDTO);
//            System.out.println("==================");
//            System.out.println(employeeJson);
//            System.out.println("==================");
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
=======

>>>>>>> j/master
}
