package com.example.demo.service.project;

import com.example.demo.mapper.project.ProjectEmplInsertMapper;
import com.example.demo.mapper.project.ProjectMapper;
import com.example.demo.model.project.Participant;
import com.example.demo.model.project.inparticipa;
import com.example.demo.model.user.CareerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SProjectEmplInsertService {
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("STATIC");
    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);
    private static ProjectEmplInsertMapper projectEmplInsertMapper;
    @Autowired
    public SProjectEmplInsertService(ProjectEmplInsertMapper projectEmplInsertMapper) {
        this.projectEmplInsertMapper = projectEmplInsertMapper;
    }

    public static inparticipa projectEmpInsert(inparticipa param) {

        return projectEmplInsertMapper.inPaprEm(param);

    }


}
