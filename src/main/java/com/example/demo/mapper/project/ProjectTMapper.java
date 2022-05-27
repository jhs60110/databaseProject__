package com.example.demo.mapper.project;

import com.example.demo.model.project.Participant;
import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.project.ProjectTDescr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectTMapper {
    List<ProjectTDescr> selectTProject();

    List<ProjectTDescr> getATProject(ProjectTDescr projectTDescr);

    List<Participant> getEmplInProject(Participant push_pr_id);

}

