package com.example.demo.service.project;

import com.example.demo.mapper.project.ProjectEmplInsertMapper;
import com.example.demo.mapper.project.ProjectMapper;
import com.example.demo.model.project.Participant;
import com.example.demo.model.user.SkillSetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticiService {
        private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("STATIC");
        private static final Logger logger = LoggerFactory.getLogger(com.example.demo.service.project.ProjectService.class);
        private static ProjectMapper projectMapper;
        private static ProjectEmplInsertMapper projectEmplInsertMapper;
        @Autowired
        public ParticiService(ProjectEmplInsertMapper projectEmplInsertMapper) {
                this.projectEmplInsertMapper = projectEmplInsertMapper;
        }
//        public List<Participant> getParticipant(String e_id);
//
//        public static List<Participant> getParticipant(Participant push_e_id) {
//                return projectEmplInsertMapper.getAParticipant(String.valueOf(push_e_id));
//        }

        public static List<Participant> getEmplInProject(Participant participant) {
//        return projectMapper.getEmplInProject(participant);
                return projectMapper.getEmplInProject(participant);
        }
}
