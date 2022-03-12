package com.example.service.impl;

import com.example.mapper.StuMapper;
import com.example.pojo.Stu;
import com.example.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package: com.example.service.impl
 * @ClassName: StuServiceImpl
 * @Author: guoyy
 * @Description: 
 * @Date: 2022/3/10 下午9:40
 * @Version: 1.0
*/
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    /*
     * @Method getStuInfo
     * @Version  1.0
     * @Description 利用mybatis通用mapper提供的方法selectByPrimaryKey(id)获得指定信息
     * @param id
     * @Return com.example.pojo.Stu
     * @Exception
     * @Date 2022/3/10 下午9:44
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveStu() {
        Stu stu = new Stu();
        stu.setAge(12);
        stu.setName("jerry");
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStu(int id) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setAge(18);
        stu.setName("alice");
        stuMapper.updateByPrimaryKey(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void saveParent() {
        Stu stu = new Stu();
        stu.setAge(12);
        stu.setName("parent");

        //int a = 1 / 0;
        stuMapper.insert(stu);
        //int a = 1 / 0;

    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void saveChild() {
        saveChild1();

        //int a = 1 / 0;

        saveChild2();
    }

    public void saveChild1() {
        Stu stu = new Stu();
        stu.setAge(14);
        stu.setName("child-1");
        stuMapper.insert(stu);
    }

    public void saveChild2() {
        Stu stu = new Stu();
        stu.setAge(14);
        stu.setName("child-2");
        stuMapper.insert(stu);
    }
}
