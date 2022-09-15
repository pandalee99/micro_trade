package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "com-sodse-trade-domain-MerchantMoveNews")
public class MerchantMoveNews implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    @ApiModelProperty(value = "")
    private Long merchantId;

    @ApiModelProperty(value = "")
    private String moveNewName;

    @ApiModelProperty(value = "")
    private String moveNewCreatTime;

    @ApiModelProperty(value = "")
    private String moveNewContent;

    @ApiModelProperty(value = "")
    private String moveNewImg;

    @ApiModelProperty(value = "")
    private String merchantName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMoveNewName() {
        return moveNewName;
    }

    public void setMoveNewName(String moveNewName) {
        this.moveNewName = moveNewName == null ? null : moveNewName.trim();
    }

    public String getMoveNewCreatTime() {
        return moveNewCreatTime;
    }

    public void setMoveNewCreatTime(String moveNewCreatTime) {
        this.moveNewCreatTime = moveNewCreatTime == null ? null : moveNewCreatTime.trim();
    }

    public String getMoveNewContent() {
        return moveNewContent;
    }

    public void setMoveNewContent(String moveNewContent) {
        this.moveNewContent = moveNewContent == null ? null : moveNewContent.trim();
    }

    public String getMoveNewImg() {
        return moveNewImg;
    }

    public void setMoveNewImg(String moveNewImg) {
        this.moveNewImg = moveNewImg == null ? null : moveNewImg.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", moveNewName=").append(moveNewName);
        sb.append(", moveNewCreatTime=").append(moveNewCreatTime);
        sb.append(", moveNewContent=").append(moveNewContent);
        sb.append(", moveNewImg=").append(moveNewImg);
        sb.append(", merchantName=").append(merchantName);
        sb.append("]");
        return sb.toString();
    }
}