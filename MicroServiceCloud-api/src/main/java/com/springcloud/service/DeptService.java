package com.springcloud.service;


import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(name = "DEPT-PROVIDER",fallbackFactory = MyFallbackHandler.class)
public interface DeptService {
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> get();
}
