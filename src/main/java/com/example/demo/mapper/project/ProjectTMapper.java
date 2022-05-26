package com.example.demo.mapper.project;

import com.example.demo.model.project.ProjectTDescr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectTMapper {
    List<ProjectTDescr> selectTProject();
}

