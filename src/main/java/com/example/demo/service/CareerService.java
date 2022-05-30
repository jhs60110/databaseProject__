package com.example.demo.service;

import com.example.demo.model.user.CareerDto;
import com.example.demo.model.user.SkillSetDto;

import java.util.List;

public interface CareerService {
    public List<CareerDto> getCareerInfo(String e_id);
}
