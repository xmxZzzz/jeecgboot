package com.example.service.impl;

import com.example.enums.Sex;
import com.example.mapper.UsersMapper;
import com.example.pojo.Users;
import com.example.pojo.bo.UserBO;
import com.example.service.UserService;
import com.example.utils.DateUtil;
import com.example.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_PATH = "https://img.zcool.cn/community/01c13f5b56bd8ba8012036be3d28b7.png@2o.png";

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private Sid sid;

    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria exampleCriteria = userExample.createCriteria();
        exampleCriteria.andEqualTo("username", username);
        Users users = usersMapper.selectOneByExample(userExample);
        return users != null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {

        //try {
        //    Thread.sleep(3500);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        Users user = new Users();
        // id:利用idworkder生成的固定16位的字母数字混编的字符串
        String id = sid.nextShort();
        user.setId(id);
        // 用户名
        user.setUsername(userBO.getUsername());
        // 使用MD5加密后的面膜
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 默认昵称与用户名一致
        user.setNickname(userBO.getUsername());
        // 默认性别为保密
        user.setSex(Sex.secret.getType());
        // 默认头像
        user.setFace(USER_PATH);
        // 默认生日为1900-01-01
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认创建时间和更新时间都是目前
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);

        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {

        //try {
        //    Thread.sleep(2500);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        // property与User.java中的属性保持一致
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", password);
        Users users = usersMapper.selectOneByExample(userExample);
        return users;
    }
}
