package com.example.service;

import com.example.pojo.Category;
import com.example.pojo.vo.CategoryVO;
import com.example.pojo.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有一级分类
     *
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据指定一级分类ID获取其子分类列表
     *
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 根据指定一级分类ID获取最新6条商品数据
     *
     * @param rootCatId
     * @return
     */
    List<NewItemsVO> getSixNewItemsList(Integer rootCatId);
}
