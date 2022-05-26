package com.example.demo.service.project;

import com.example.demo.mapper.project.ProjectTMapper;
import com.example.demo.model.project.ProjectTDescr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectTService {
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("STATIC");
    private static final Logger logger = LoggerFactory.getLogger(ProjectTService.class);
    private static ProjectTMapper projectTMapper;
    @Autowired
    public ProjectTService(ProjectTMapper projectTMapper){
        this.projectTMapper = projectTMapper;}

    public List<ProjectTDescr> selectTProject(){

        return projectTMapper.selectTProject();
    }
}
