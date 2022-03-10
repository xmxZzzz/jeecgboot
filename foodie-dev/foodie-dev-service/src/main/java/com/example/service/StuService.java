package com.example.service;

import com.example.pojo.Stu;

/**
 * @Package: com.example.service
 * @ClassName: StuService
 * @Author: guoyy
 * @Description: 
 * @Date: 2022/3/10 下午9:40
 * @Version: 1.0
*/
public interface StuService {

    Stu getStuInfo(int id);

    void saveStu();

    void updateStu(int id);

    void deleteStu(int id);

    //测试事务
    void saveParent();

    void saveChild();

}
