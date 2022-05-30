package com.example.demo.mapper.user;

import com.example.demo.model.user.SkillSetDto;
import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    //회원 저장(회원가입)
    void createUser(employeeDto employeeDTO);


    //회원의 정보 조회 (로그인)
    User getLoginInfo(@Param("id") String id); //여기? 뭐? 이상?
    //회원 정보 조회(마이페이지, 통계페이지)
    public employeeDto getUserInfo(String userID);
    public employeeDto getEmployeeInfo(String e_name);

    public int getEmployeeTotalCount(employeeDto params);

    // employee 리스트 받아오기
    public List<employeeDto> getEmployeeList(employeeDto params);

    //회원 정보 수정(마이페이지)
    public void updateUserInfo(employeeDto userInfoRequestDto);

//    회원 정보 수정(skill 수정)
    public void deleteSkillSet(String e_id);
    public void insertSkillSet(@Param("language") String language, @Param("framework") String framework,
                               @Param("e_id") String e_id);

    //    회원 정보 수정(skill 수정)
    public void deleteCareer(String e_id);
    public void insertCareer(@Param("ca_name") String ca_name, @Param("ca_description") String ca_description,
                               @Param("e_id") String e_id);

}

