package com.example.enums;

/**
 * @Package: com.example.enums
 * @ClassName: CommentLevel
 * @Author: guoyy
 * @Description: 表示商品评价登记的枚举类： 1：好评 2：中评 3：差评
 * @Date: 2022/3/16 下午11:02
 * @Version: 1.0
 */
public enum CommentLevel {

    GOOD(1, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评");

    private final Integer type;
    private final String value;

    CommentLevel(Integer type, String value) {
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
