package com.example.service;

import com.example.pojo.Items;
import com.example.pojo.ItemsImg;
import com.example.pojo.ItemsParam;
import com.example.pojo.ItemsSpec;
import com.example.pojo.vo.CommentLevelCountsVO;
import com.example.utils.PagedGridResult;

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

    /**
     * 根据商品ID获取商品评价等级数量
     *
     * @param itemId
     * @return
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 根据指定商品ID获取评价信息（分页）
     *
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryItemComments(String itemId, Integer level, Integer page, Integer pageSize);
}
