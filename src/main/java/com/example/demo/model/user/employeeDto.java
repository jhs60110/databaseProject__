package com.example.demo.model.user;

import com.example.demo.model.CommonDTO;
import lombok.Getter;
import lombok.Setter;


//@Getter
//@Setter
//public class employeeDto extends CommonDTO {
////    private String e_id;
////    private String e_name;
////    private String resident_num;
////    private String academic_level;
////    private String r_id;
//    private String eId;
//    private String eName;
//    private String residentNum;
//    private String academicLevel;
//    private String role;
//    private String id;
//    private String password;
//    private String department;
//
//    private String errorMessage;


@Getter
@Setter
public class employeeDto extends CommonDTO {

//    private String residentNum;
    private String role;
    private String e_name;
    private String resident_num;
    private String academic_level;
    private String e_id;
    private String id;
    private String password;
    private String department;
    private String errorMessage;

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

//    public String getResidentNum() {
//        return residentNum;
//    }
//    public void setResidentNum(String residentNum) {
//        this.residentNum = residentNum;
//    }
//    public void setResidentNum(String residentNum) {
//        this.resident_num = residentNum;
//    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getResident_num() {
        return resident_num;
    }

    public void setResident_num(String resident_num) {
        this.resident_num = resident_num;
    }

    public String getAcademic_level() {
        return academic_level;
    }

    public void setAcademic_level(String academic_level) {
        this.academic_level = academic_level;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
