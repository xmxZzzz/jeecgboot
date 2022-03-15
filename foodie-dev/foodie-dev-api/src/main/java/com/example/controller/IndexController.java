package com.example.controller;

import com.example.enums.YesOrNo;
import com.example.pojo.Carousel;
import com.example.pojo.Category;
import com.example.pojo.vo.CategoryVO;
import com.example.pojo.vo.NewItemsVO;
import com.example.service.CarouselService;
import com.example.service.CategoryService;
import com.example.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package: com.example.controller
 * @ClassName: IndexController
 * @Author: guoyy
 * @Description: 首页相关信息
 * @Date: 2022/3/14 下午10:14
 * @Version: 1.0
 */
@Api(value = "首页", tags = "首页展示的相关接口")
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页所有轮播图", notes = "获取首页轮播图的列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel() {
        List<Carousel> result = carouselService.queryAll(YesOrNo.YES.getType());
        return IMOOCJSONResult.ok(result);
    }

    /**
     * 首页分类展示需求
     * 1.第一次刷新首页查询大分类，渲染展示到首页
     * 2.如果鼠标移动到大分类傻姑娘，则加载其子分类的内容；如果已经存在子分类，则不需要加载（蓝加载）
     */

    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats() {
        List<Category> result = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(result);
    }

    @ApiOperation(value = "查询商品子分类", notes = "查询商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(@ApiParam(name = "rootCatId", value = "一级分类ID", required = true) @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("");
        }
        List<CategoryVO> result = categoryService.getSubCatList(rootCatId);
        return IMOOCJSONResult.ok(result);
    }

    @ApiOperation(value = "查询指定一级分类下的最新6条商品数据", notes = "查询指定一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult sixNewItems(@ApiParam(name = "rootCatId", value = "一级分类ID", required = true) @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("");
        }
        List<NewItemsVO> result = categoryService.getSixNewItemsList(rootCatId);
        return IMOOCJSONResult.ok(result);
    }
}
