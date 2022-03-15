package com.example.mapper;

import com.example.pojo.vo.CategoryVO;
import com.example.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {
    /**
     * 根据指定一级分类id查询其子分类下所有信息
     *
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 根据指定一级分类ID，获取最新6条商品数据
     *
     * @param map
     * @return
     */
    List<NewItemsVO> getSixNewItemLazy(@Param("params") Map<String, Object> map);
}