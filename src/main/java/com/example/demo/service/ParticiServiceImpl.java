package com.example.demo.service;

import com.example.demo.mapper.project.ProjectEmplInsertMapper;
import com.example.demo.mapper.user.SkillSetMapper;
import com.example.demo.model.project.Participant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ParticiServiceImpl implements ParticiService {

    @Autowired
    private ProjectEmplInsertMapper ProjectEmplInsertMapper;

    @Override
    public List<Participant> getParticipant(String e_id) {

        return ProjectEmplInsertMapper.getAParticipant(e_id);
    }
}
