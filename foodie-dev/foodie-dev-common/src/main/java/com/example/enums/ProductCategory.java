package com.example.enums;

/**
 * @Package: com.example.enums
 * @ClassName: Category
 * @Author: guoyy
 * @Description: 表示商品类别的枚举类： 1：一级 2：二级 3：三级
 * @Date: 2022/3/14 下午11:43
 * @Version: 1.0
 */
public enum ProductCategory {

    ONE(1, "一级分类"),
    TWO(2, "二级分类"),
    THREE(3, "三级分类");

    private final Integer type;
    private final String value;

    ProductCategory(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
