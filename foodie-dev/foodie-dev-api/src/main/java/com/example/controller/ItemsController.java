package com.example.controller;

import com.example.pojo.Items;
import com.example.pojo.ItemsImg;
import com.example.pojo.ItemsParam;
import com.example.pojo.ItemsSpec;
import com.example.pojo.vo.ItemInfoVO;
import com.example.service.ItemsService;
import com.example.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "商品详情", tags = {"商品详情相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @ApiOperation(value = "商品详情", notes = "商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(@PathVariable String itemId) {
        if (StringUtils.isBlank(itemId)) {
            return IMOOCJSONResult.errorMsg(null);
        }

        Items item = itemsService.queryItemById(itemId);
        List<ItemsImg> itemImgList = itemsService.queryItemsImgList(itemId);
        List<ItemsSpec> itemSpecList = itemsService.queryItemsSpecList(itemId);
        ItemsParam itemParams = itemsService.queryItemParam(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemImgList(itemImgList);
        itemInfoVO.setItemSpecList(itemSpecList);
        itemInfoVO.setItemParams(itemParams);

        return IMOOCJSONResult.ok(itemInfoVO);

    }
}
