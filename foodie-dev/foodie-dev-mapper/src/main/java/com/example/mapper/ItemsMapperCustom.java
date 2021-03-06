package com.example.mapper;

import com.example.pojo.vo.ItemCommentsVO;
import com.example.pojo.vo.SearchItemsVO;
import com.example.pojo.vo.ShopCartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    List<ItemCommentsVO> queryItemsCommentList(@Param("params") Map<String, Object> map);

    List<SearchItemsVO> searchItems(@Param("params") Map<String, Object> map);

    List<SearchItemsVO> searchItemsByThirdCat(@Param("params") Map<String, Object> map);

    List<ShopCartVO> queryItemsBySpecIds(@Param("paramsList") List<String> specIdsList);
}