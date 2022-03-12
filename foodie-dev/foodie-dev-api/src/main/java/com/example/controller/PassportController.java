package com.example.controller;

import com.example.pojo.bo.UserBO;
import com.example.service.UserService;
import com.example.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public IMOOCJSONResult regist(@RequestBody UserBO userBO) {
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
        userService.createUser(userBO);

        return IMOOCJSONResult.ok();

    }

}
