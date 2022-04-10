package com.example.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AddressBO", description = "从前端传入的待新增的收货地址BO")
public class AddressBO {

    @ApiModelProperty(name = "addressId", value = "地址主键id")
    private String addressId;
    @ApiModelProperty(name = "userId", value = "关联用户ID")
    private String userId;
    @ApiModelProperty(name = "receiver", value = "收件人姓名", notes = "不超过12位")
    private String receiver;
    @ApiModelProperty(name = "mobile", value = "收件人手机号")
    private String mobile;
    @ApiModelProperty(name = "province", value = "省份")
    private String province;
    @ApiModelProperty(name = "city", value = "城市")
    private String city;
    @ApiModelProperty(name = "district", value = "区县")
    private String district;
    @ApiModelProperty(name = "detail", value = "详细地址")
    private String detail;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
