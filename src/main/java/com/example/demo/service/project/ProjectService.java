package com.example.demo.service.project;

import com.example.demo.mapper.project.ProjectMapper;
import com.example.demo.model.project.Participant;
import com.example.demo.model.project.ProjectDescr;
import com.example.demo.model.project.ProjectTDescr;
import com.example.demo.model.user.User;
import com.example.demo.model.user.employeeDto;
import com.example.demo.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Collections;
import java.util.List;

@Service
public class ProjectService {
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("STATIC");
    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);
    private static ProjectMapper projectMapper;

    @Autowired
    public ProjectService(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public static List<ProjectDescr> getAProject(ProjectDescr projectDescr) {
        return projectMapper.getAProject(projectDescr);

    }

    public static ProjectDescr getProjectById(String pr_id) {
        return projectMapper.getProjectById(pr_id);

    }

    public static List<Participant> getEmplInProject(Participant participant) {
//        return projectMapper.getEmplInProject(participant);
        return projectMapper.getEmplInProject(participant);
    }


    public List<ProjectDescr> selectNTProject(ProjectDescr params) {
        return projectMapper.selectNTProject();
    }

    public static void createProject(ProjectDescr projectDescr) {

        projectMapper.createProject(projectDescr);
    }

    public static void updateProject(ProjectDescr projectDescr) {

        projectMapper.updateProject(projectDescr);
    }

    public static void updateProjectT(ProjectTDescr projectDescr) {

        projectMapper.updateProjectT(projectDescr);
    }

    public static void insertParticipant(Participant participant) {
        projectMapper.insertParticipant(participant);
    }

    //  모든 project 조회

    public List<ProjectDescr> getProjectList(ProjectDescr params) {
        List<ProjectDescr> projectList = Collections.emptyList();
        int projectTotalCount = projectMapper.getProjectTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(projectTotalCount);

        params.setPaginationInfo(paginationInfo);
        if (projectTotalCount > 0) {
            projectList = projectMapper.getProjectList(params);
        }
        return projectList;
    }

    public List<ProjectDescr> getProjectTList(ProjectDescr params) {
        List<ProjectDescr> projectList = Collections.emptyList();
        int projectTotalCount = projectMapper.getProjectTTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(projectTotalCount);

        params.setPaginationInfo(paginationInfo);
        if (projectTotalCount > 0) {
            projectList = projectMapper.getProjectTList(params);
        }
        return projectList;
    }
}
