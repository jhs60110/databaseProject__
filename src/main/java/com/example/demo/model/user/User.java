package com.example.demo.model.user;

import com.example.demo.model.ProcedureOutMsg;
import com.example.demo.model.user.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class User extends ProcedureOutMsg implements UserDetails, Serializable {
    Logger logger = LoggerFactory.getLogger("User");
    private static final String ROLE_PREFIX = "ROLE_";

    private boolean enable = true;

    private Long e_id;

    private String e_name;
    private String resident_num;
    private String academic_level;

    private String id;
    private String password;
    private String department;

    private String errorCode;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public Long getE_id() {return e_id;}

    public void setE_id(Long e_id) {this.e_id = e_id;}

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



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return e_name;
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        logger.info("User Model role : " + roles);
        List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
        roles.forEach(role -> roleList.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRole())));
        return roleList;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }


}