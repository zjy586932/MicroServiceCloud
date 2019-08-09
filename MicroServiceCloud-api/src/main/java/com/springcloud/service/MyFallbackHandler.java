package com.springcloud.service;

import com.netflix.ribbon.hystrix.FallbackHandler;
import com.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务降级回调函数
 */
@Component
public class MyFallbackHandler implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public List<Dept> get() {
                Dept dept = new Dept().setDeptname("服务降级");
                ArrayList<Dept> depts = new ArrayList<>();
                depts.add(dept);
                return depts;
            }
        };
    }
}
