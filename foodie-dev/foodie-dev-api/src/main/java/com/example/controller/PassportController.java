package com.example.controller;

import com.example.pojo.Users;
import com.example.pojo.bo.UserBO;
import com.example.service.UserService;
import com.example.utils.CookieUtils;
import com.example.utils.IMOOCJSONResult;
import com.example.utils.JsonUtils;
import com.example.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    /*
     * @Method usernameIsExist
     * @Version  1.0
     * @Description 判断用户名是否已存在
     * @param username
     * @Return 自定义响应数据结构IMOOCJSONResult
     * @Exception
     * @Date 2022/3/12 下午5:31
     */
    @ApiOperation(value = "用户名是否存在", notes = "判断用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username) {
        // 1.判断用户名不能为空，包括“”和“   ”
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
            //return HttpStatus.INTERNAL_SERVER_ERROR;
            //return 500;
        }
        // 2.查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
            //return HttpStatus.INTERNAL_SERVER_ERROR;
            //return 500;
        }
        // 3. 请求成功，用户名没有重复
        return IMOOCJSONResult.ok();
        //return HttpStatus.OK;
        //return 200;
    }

    /*
     * @Method regist
     * @Version  1.0
     * @Description 用户注册
     * @param userBO 前端传入的JSON
     * @Return com.example.utils.IMOOCJSONResult
     * @Exception
     * @Date 2022/3/12 下午10:55
     */
    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        String username = userBO.getUsername();
        String pwd = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 用户名、密码、确认密码都不为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(pwd) || StringUtils.isBlank(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1.用户名不存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }

        // 2.密码的长度不小于6位
        if (pwd.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码的长度不能小于6");
        }

        // 3.输入的两次密码必须一致
        if (!pwd.equals(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("输入的两次密码不一致");
        }

        // 4.实现注册
        Users userRes = userService.createUser(userBO);

        //2.将登录用户的信息存入cookie
        userRes = setNullProperty(userRes);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userRes), true);

        return IMOOCJSONResult.ok();

    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserBO userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String username = userBO.getUsername();
        String pwd = userBO.getPassword();

        //0.用户名和密码都不能为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank((pwd))) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        //1.实现用户登录
        Users userRes = userService.queryUserForLogin(username, MD5Utils.getMD5Str(pwd));

        if (userRes == null) {
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }

        //2.将登录用户的信息存入cookie
        userRes = setNullProperty(userRes);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userRes), true);

        return IMOOCJSONResult.ok(userRes);
    }

    /*
     * @Method setNullProperty
     * @Version  1.0
     * @Description 将需要存入cookie的用户信息中的敏感字段隐藏
     * @param user
     * @Return com.example.pojo.Users
     * @Exception
     * @Date 2022/3/13 下午5:36
     */
    private Users setNullProperty(Users user) {
        user.setPassword(null);
        user.setBirthday(null);
        user.setMobile(null);
        user.setEmail(null);
        user.setRealname(null);
        user.setCreatedTime(null);
        user.setUpdatedTime(null);
        return user;
    }

    @ApiOperation(value = "用户退出", notes = "用户退出", httpMethod = "POST")
    @PostMapping("logout")
    public IMOOCJSONResult logout(@RequestParam String userId, HttpServletRequest request, HttpServletResponse response) {
        // 清除cookie中的用户信息
        CookieUtils.deleteCookie(request, response, "user");

        // TODO 用户退出登录，需要清空购物车
        // TODO 分布式会话中需要清除用户数据

        return IMOOCJSONResult.ok();
    }

}
