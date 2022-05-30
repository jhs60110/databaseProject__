package com.example.demo.service;

import com.example.demo.model.user.SkillSetDto;

import java.util.List;

public interface SkillSetService {
    //    사번으로 skill 조회
    public List<SkillSetDto> getSkillSetInfo(String e_id);

}