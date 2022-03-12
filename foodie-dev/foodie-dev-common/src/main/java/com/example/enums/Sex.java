package com.example.enums;

/**
 * @Package: com.example.enums
 * @ClassName: Sex
 * @Author: guoyy
 * @Description: 表示性别的枚举类： 0：男 1：女 2：保密
 * @Date: 2022/3/12 下午9:22
 * @Version: 1.0
 */
public enum Sex {

    female(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    private final Integer type;
    private final String value;

    Sex(Integer type, String value) {
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
