package com.example.pojo.vo;

import java.util.List;

/**
 * @Package: com.example.pojo.vo
 * @ClassName: CategoryVO
 * @Author: guoyy
 * @Description: 商品二级分类信息
 * @Date: 2022/3/14 下午11:57
 * @Version: 1.0
 */
public class CategoryVO {
    private Integer id;
    private String name;
    private Integer type;
    private Integer fatherId;
    //三级目录信息列表
    private List<SubCategoryVO> subCatList;

    public List<SubCategoryVO> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCategoryVO> subCatList) {
        this.subCatList = subCatList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }
}
