package com.example.demo.mapper.project;

import com.example.demo.model.project.Participant;
import com.example.demo.model.project.inparticipa;
import com.example.demo.model.user.SkillSetDto;
import com.example.demo.model.user.employeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProjectEmplInsertMapper {

    inparticipa inPaprEm(inparticipa params);

     List<Participant> getAParticipant(String e_id);

//    public List<SkillSetDto> getSkillSetInfo(String e_id);

}
