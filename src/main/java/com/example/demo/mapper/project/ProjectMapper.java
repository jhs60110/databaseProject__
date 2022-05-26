package com.example.demo.mapper.project;

import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.user.employeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {
    List<ProjectDescr> selectNTProject();

    int getProjectTotalCount(ProjectDescr params);

    void createProject(ProjectDescr projectDescr);

    // project 리스트 받아오기
     List<ProjectDescr> getProjectList(ProjectDescr params);
}
