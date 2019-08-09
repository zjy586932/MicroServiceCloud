package com.springcloud.service;

import com.springcloud.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Override
    public List get() {
        ArrayList<Dept> depts = new ArrayList<>();
        depts.add(new Dept().setDetpno(1l).setDeptname("11").setDb_source("db71"));
        return depts;
    }
}
