package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "com-sodse-trade-domain-UserCollection")
public class UserCollection implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 收藏的物品id
     */
    @ApiModelProperty(value = "收藏的物品id")
    private Long productId;

    /**
     * 用户的id唯一
     */
    @ApiModelProperty(value = "用户的id唯一")
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}