package com.springcloud.controller;

import com.springcloud.entity.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Value("${spring.application.name}")
    String host;

    @RequestMapping(value = "dept/list",method = RequestMethod.GET)
    public List<Dept> get(){
        return deptService.get();
    }
}
