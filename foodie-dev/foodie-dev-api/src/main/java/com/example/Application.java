package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 扫描mybatis通用mapper所在的包
@MapperScan(basePackages = "com.example.mapper")
// 已自动装配，不需要该注解了
//@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
