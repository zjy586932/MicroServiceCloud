package com.springcloud.controller;

import com.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    private final String RestUrl_prefix = "http://DEPT-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List get(){
        return restTemplate.getForObject(RestUrl_prefix + "/dept/list", List.class);
    }
}
