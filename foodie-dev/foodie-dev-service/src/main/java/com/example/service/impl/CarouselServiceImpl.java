package com.example.service.impl;

import com.example.mapper.CarouselMapper;
import com.example.pojo.Carousel;
import com.example.service.CarouselService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package: com.example.service.impl
 * @ClassName: CarouselServiceImpl
 * @Author: guoyy
 * @Description: 轮播图相关
 * @Date: 2022/3/14 下午10:13
 * @Version: 1.0
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example carouselExample = new Example(Carousel.class);
        // 按照sort字段进行升序排列
        carouselExample.orderBy("sort").asc();
        Example.Criteria criteria = carouselExample.createCriteria();
        criteria.andEqualTo("isShow", isShow);
        List<Carousel> res = carouselMapper.selectByExample(carouselExample);
        return res;
    }
}
