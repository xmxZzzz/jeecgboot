package com.example.controller;

import com.example.pojo.Stu;
import com.example.service.StuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

// 在Swagger2中忽略该类
@ApiIgnore
@RestController
public class StuController {

    private final StuService stuService;

    /*
     * @Method StuController
     * @Version  1.0
     * @Description 使用构造器注入
     * @param stuService
     * @Return
     * @Exception
     * @Date 2022/3/10 下午9:55
     */
    public StuController(StuService stuService){
        this.stuService=stuService;
    }

    /*
     * @Method getStu
     * @Version  1.0
     * @Description 根据指定id获取Stu
     * @param id
     * @Return com.example.pojo.Stu
     * @Exception
     * @Date 2022/3/10 下午9:56
     */
    @GetMapping(path = "/getStu")
    public Stu getStu(int id){
        return stuService.getStuInfo(id);
    }

    @PostMapping(path = "/saveStu")
    public Object saveStu(){
        stuService.saveStu();
        return "OK";
    }

    @PostMapping(path = "/updateStu")
    public Object updateStu(int id){
        stuService.updateStu(id);
        return "OK";
    }

    @PostMapping(path = "/deleteStu")
    public Object deleteStu(int id){
        stuService.deleteStu(id);
        return "OK";
    }

}
