package com.example.mapper;

import com.example.pojo.vo.ItemCommentsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    List<ItemCommentsVO> queryItemsCommentList(@Param("params") Map<String, Object> map);
}