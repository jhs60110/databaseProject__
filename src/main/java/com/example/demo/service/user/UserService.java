package com.example.demo.service.user;

import com.example.demo.mapper.user.UserMapper;
import com.example.demo.model.user.Role;
import com.example.demo.model.user.SkillSetDto;
import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("USER");
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //회원 저장(회원가입)
    public static void createUser(employeeDto employeeDTO) {
        userMapper.createUser(employeeDTO);
    }
    //회원 정보 조회(마이페이지, 통계페이지)
    public static employeeDto getUserInfo(String userID) {

        return userMapper.getUserInfo(userID);
    }

//    회원 정보 수정
    public static void updateUserInfo(employeeDto employeeDto) {userMapper.updateUserInfo(employeeDto);}

//    회원 정보 수정(skill 수정)
    public static void updateSkillSet(List languageList, List frameworkList, String e_id){
        userMapper.deleteSkillSet(e_id);
        int num;
        if (languageList.size() > frameworkList.size()) {
            num = languageList.size();
        } else {
            num = frameworkList.size();
        }
        for (int i = 0; i < num; i++) {
            try{
                userMapper.insertSkillSet((String) languageList.get(i), (String) frameworkList.get(i), e_id);
            } catch (ArrayIndexOutOfBoundsException e) {
                if (num == languageList.size()) {
                    userMapper.insertSkillSet((String) languageList.get(i), "", e_id);
                } else {
                    userMapper.insertSkillSet("", (String) frameworkList.get(i), e_id);
                }
            }
        }
    }

    //    회원 정보 수정(career 수정)
    public static void updateCareer(List caNameList, List caDescList, String e_id){
        userMapper.deleteCareer(e_id);
        int num;
        if (caNameList.size() > caDescList.size()) {
            num = caNameList.size();
        } else {
            num = caDescList.size();
        }
        for (int i = 0; i < num; i++) {
            try{
                userMapper.insertCareer((String) caNameList.get(i), (String) caDescList.get(i), e_id);
            } catch (ArrayIndexOutOfBoundsException e) {
                if (num == caNameList.size()) {
                    userMapper.insertCareer((String) caNameList.get(i), "", e_id);
                } else {
                    userMapper.insertCareer("", (String) caDescList.get(i), e_id);
                }
            }
        }
    }

    //회원 정보 조회 (로그인)
    public User getLoginInfo(String id) {
        User user = userMapper.getLoginInfo(id);
        if (user != null) {
            logger.info("-------user not null-----");
            logger.info("login userID : {}", user.getId());
            if (user.getErrorCode() == null) {
                user.setErrorCode("");
                logger.info("login errorCode : {}", user.getErrorCode());
            }
            if (!"".equals(user.getErrorCode())) {
                logger.info("log error : " + user.getErrorCode());
            }
            processUserRole(user);

        } else {

            logger.info("-------user null-----");
        }
        return user;
    }


    //user 회원과 manager 구분
    private void processUserRole(User user) {
        if (user != null) {
            logger.info("User Service RoleType: {}", user.getRole());
            user.setRoles(new HashSet<>(Arrays.asList(new Role(user.getRole()))));

        } else {
            logger.info("권한 안뜸");
        }
    }



}