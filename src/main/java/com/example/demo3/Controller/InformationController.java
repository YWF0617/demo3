package com.example.demo3.Controller;

import com.example.demo3.entity.Information;
import com.example.demo3.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class InformationController {

    @Resource
    InformationService informationService;

    @PostMapping("/information/selectInformation")
    public List<Information> selectInformation(){
        return informationService.selectInformation();
    }



    //TODO 查询：按时间查询、按点击量查询、模糊查询（均分页查询)  模糊查询整合es引擎
    //TODO 查询：根据ID或url查询单条记录 每访问接口一次，click+1  update语句


    //TODO  删除：根据id删除

    //TODO 新增



}
