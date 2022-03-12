package com.example.service;

import com.example.pojo.Users;
import com.example.pojo.bo.UserBO;

public interface UserService {

    /**
     * 判断username是否已存在
     *
     * @param username 请求参数
     * @return 布尔值
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     *
     * @param userBO 请求参数：用户名、密码、确认密码
     * @return 返回成功创建的用户信息
     */
    Users createUser(UserBO userBO);
}
