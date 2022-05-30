package com.example.demo.mapper.user;

import com.example.demo.model.user.SkillSetDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SkillSetMapper {
    public List<SkillSetDto> getSkillSetInfo(String e_id);
}