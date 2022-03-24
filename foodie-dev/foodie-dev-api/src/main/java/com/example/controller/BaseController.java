package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.example.controller
 * @ClassName: BaseController
 * @Author: guoyy
 * @Description: 基础Controller，存放默认信息
 * @Date: 2022/3/17 上午12:47
 * @Version: 1.0
 */
@RestController
public class BaseController {

    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;
}
