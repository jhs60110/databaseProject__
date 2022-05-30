package com.example.demo.service.project;

import com.example.demo.mapper.project.ProjectEmplInsertMapper;
import com.example.demo.model.project.inparticipa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Service;

@Service
public class SProjectEmplInsertService {
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("STATIC");
    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);
    private static ProjectEmplInsertMapper projectEmplInsertMapper;

    public static inparticipa projectEmpInsert(inparticipa param) {

        projectEmplInsertMapper.inPaprEm(param);
        return param;
    }
}
