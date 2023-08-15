package com.example.demo3.service;

import com.example.demo3.entity.Information;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface InformationService {


    public  List<Information> selectInformation();
}
