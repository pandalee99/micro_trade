package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="com-sodse-trade-domain-Merchants")
public class Merchants implements Serializable {
    @ApiModelProperty(value="")
    private Long merchantId;

    /**
    * 每个商家都是一个用户
    */
    @ApiModelProperty(value="每个商家都是一个用户")
    private Long userId;

    /**
    * 商家的名字
    */
    @ApiModelProperty(value="商家的名字")
    private String merchantName;

    /**
    * 店铺名字
    */
    @ApiModelProperty(value="店铺名字")
    private String shopName;

    @ApiModelProperty(value="")
    private String merchantImg;

    @ApiModelProperty(value="")
    private String merchantDescription;

    private static final long serialVersionUID = 1L;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getMerchantImg() {
        return merchantImg;
    }

    public void setMerchantImg(String merchantImg) {
        this.merchantImg = merchantImg == null ? null : merchantImg.trim();
    }

    public String getMerchantDescription() {
        return merchantDescription;
    }

    public void setMerchantDescription(String merchantDescription) {
        this.merchantDescription = merchantDescription == null ? null : merchantDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchantId=").append(merchantId);
        sb.append(", userId=").append(userId);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", shopName=").append(shopName);
        sb.append(", merchantImg=").append(merchantImg);
        sb.append(", merchantDescription=").append(merchantDescription);
        sb.append("]");
        return sb.toString();
    }
}