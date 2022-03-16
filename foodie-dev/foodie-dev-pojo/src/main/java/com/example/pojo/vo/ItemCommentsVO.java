package com.example.pojo.vo;

import java.util.Date;

/**
 * @Package: com.example.pojo.vo
 * @ClassName: ItemCommentsVO
 * @Author: guoyy
 * @Description: 商品评价信息VO
 * @Date: 2022/3/17 上午12:20
 * @Version: 1.0
 */
public class ItemCommentsVO {

    private Integer commentLevel;
    private String specName;
    private String content;
    private Date createdTime;
    private String nickname;
    private String userFace;

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }
}
