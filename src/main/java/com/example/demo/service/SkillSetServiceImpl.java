package com.example.demo.service;

import com.example.demo.mapper.user.SkillSetMapper;
import com.example.demo.model.user.SkillSetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillSetServiceImpl implements SkillSetService{
    @Autowired
    private SkillSetMapper skillSetMapper;

    @Override
    public List<SkillSetDto> getSkillSetInfo(String e_id) {
        return skillSetMapper.getSkillSetInfo(e_id);
    }
}
