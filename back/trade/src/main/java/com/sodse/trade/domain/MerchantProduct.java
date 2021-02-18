package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "com-sodse-trade-domain-MerchantProduct")
public class MerchantProduct implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 这个商家有多少产品
     */
    @ApiModelProperty(value = "这个商家有多少产品")
    private Long productId;

    @ApiModelProperty(value = "")
    private Long merchantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", merchantId=").append(merchantId);
        sb.append("]");
        return sb.toString();
    }
}