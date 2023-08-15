package com.example.demo3.serviceImp;

import com.example.demo3.entity.Information;
import com.example.demo3.mapper.InformationMapper;
import com.example.demo3.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InformationServiceImp implements InformationService {

    @Resource
    InformationMapper informationMapper;

    @Override
    public List<Information> selectInformation(){
        return informationMapper.findAllInformation();
    }


}
