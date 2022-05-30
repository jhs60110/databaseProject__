package com.example.demo.mapper.project;

import com.example.demo.model.project.Participant;
import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.project.ProjectTDescr;
import com.example.demo.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {


    List<ProjectDescr> getAProject(ProjectDescr projectDescr);

    List<ProjectDescr> selectNTProject();

    int getProjectTotalCount(ProjectDescr params);

    int getProjectTTotalCount(ProjectDescr params);


    void createProject(ProjectDescr projectDescr);

    void updateProject(ProjectDescr projectDescr);

    void updateProjectT(ProjectTDescr projectTDescr);

    void insertParticipant(Participant participant);

    // project 리스트 받아오기

     List<ProjectDescr> getProjectList(ProjectDescr params);

     List<ProjectDescr> getProjectTList(ProjectDescr params);

     List<Participant> getEmplInProject(Participant push_pr_id);

     ProjectDescr getProjectById(String pr_id);



}
