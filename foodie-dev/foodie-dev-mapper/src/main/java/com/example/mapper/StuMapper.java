package com.example.mapper;

import com.example.my.mapper.MyMapper;
import com.example.pojo.Stu;
import org.springframework.stereotype.Repository;

@Repository
public interface StuMapper extends MyMapper<Stu> {
}