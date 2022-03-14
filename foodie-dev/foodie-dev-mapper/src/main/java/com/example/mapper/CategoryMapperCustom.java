package com.example.mapper;

import com.example.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom {
    /**
     * 根据指定一级分类id查询其子分类下所有信息
     *
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);
}