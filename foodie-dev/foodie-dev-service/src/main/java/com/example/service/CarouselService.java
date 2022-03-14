package com.example.service;

import com.example.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * 查询所有可以展示的轮播图列表
     *
     * @param isShow 是否展示
     * @return
     */
    List<Carousel> queryAll(Integer isShow);
}
