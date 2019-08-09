package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.entity.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Value("${spring.application.name}")
    String host;

    @RequestMapping(value = "dept/list",method = RequestMethod.GET)
    //熔断以及错误处理方法getExeptionFallback
    @HystrixCommand(fallbackMethod = "getExeptionFallback")
    public List<Dept> get(){
        if(true){
            throw new RuntimeException();
        }
        return deptService.get();
    }

    public List<Dept> getExeptionFallback(){
        Dept dept = new Dept().setDeptname("查询出错");
        ArrayList<Dept> depts = new ArrayList<>();
        depts.add(dept);
        return depts;
    }
}
