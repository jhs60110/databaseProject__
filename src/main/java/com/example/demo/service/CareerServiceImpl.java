package com.example.demo.service;

import com.example.demo.mapper.user.CareerMapper;
import com.example.demo.model.user.CareerDto;
import com.example.demo.model.user.SkillSetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerServiceImpl implements CareerService{
    @Autowired
    private CareerMapper careerMapper;

    @Override
    public List<CareerDto> getCareerInfo(String e_id) {

        return careerMapper.getCareerInfo(e_id);
    }
}
