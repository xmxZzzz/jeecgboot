package com.example.pojo.vo;

/**
 * @Package: com.example.pojo.vo
 * @ClassName: SimpleItemVO
 * @Author: guoyy
 * @Description: 最新6条数据的基本信息
 * @Date: 2022/3/15 下午10:26
 * @Version: 1.0
 */
public class SimpleItemVO {
    private String itemId;
    private String itemName;
    private String itemUrl;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
