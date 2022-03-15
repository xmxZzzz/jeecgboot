package com.example.service;

import com.example.pojo.Items;
import com.example.pojo.ItemsImg;
import com.example.pojo.ItemsParam;
import com.example.pojo.ItemsSpec;

import java.util.List;

public interface ItemsService {

    /**
     * 根据商品ID获取商品基本信息
     *
     * @param itemId
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品ID获取商品图片列表
     *
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemsImgList(String itemId);

    /**
     * 根据商品ID获取商品规格列表
     *
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemsSpecList(String itemId);

    /**
     * 根据商品ID获取商品参数信息
     *
     * @param itemId
     * @return
     */
    ItemsParam queryItemParam(String itemId);
}
