package com.example.enums;

/**
 * @Package: com.example.enums
 * @ClassName: YesOrNo
 * @Author: guoyy
 * @Description: 表示是否的枚举类： 0：否 1：是
 * @Date: 2022/3/14 下午10:21
 * @Version: 1.0
 */
public enum YesOrNo {

    NO(0, "否"),
    YES(1, "是");

    private final Integer type;
    private final String value;

    YesOrNo(Integer type, String value) {
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
