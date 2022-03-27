package com.example.controller;

import com.example.pojo.bo.ShopCartBO;
import com.example.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package: com.example.controller
 * @ClassName: ShopcartController
 * @Author: guoyy
 * @Description: 购物车相关信息的Controller
 * @Date: 2022/3/24 下午11:05
 * @Version: 1.0
 */
@Api(value = "购物车相关信息的Controller", tags = {"购物车相关接口信息"})
@RestController
@RequestMapping("shopcart")
public class ShopcartController {

    private static final Logger logger = LoggerFactory.getLogger(ShopcartController.class);

    @ApiOperation(value = "将商品添加到购物车(redis缓存)", notes = "将商品添加到购物车(redis缓存)", httpMethod = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult add(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam String userId,
                               @ApiParam(name = "shopCartBO", value = "待加入购物车的商品信息", required = true) @RequestBody ShopCartBO shopCartBO,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("");
        }

        // TODO 前端用户在登录的情况下，添加商品到购物车，会同事在后端同步购物车到redis缓存

        logger.info(shopCartBO.toString());

        return IMOOCJSONResult.ok();

    }

    @ApiOperation(value = "从购物车中删除商品(redis缓存)", notes = "从购物车中删除商品(redis缓存)", httpMethod = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult del(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam String userId,
                               @ApiParam(name = "itemSpecId", value = "商品规格id", required = true) @RequestParam String itemSpecId,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return IMOOCJSONResult.errorMsg("参数不能为空");
        }

        // TODO 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除后端购物车中的商品数据

        return IMOOCJSONResult.ok();

    }
}
