package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="com-sodse-trade-domain-Coupons")
public class Coupons implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private BigDecimal couponMoney;

    @ApiModelProperty(value="")
    private String name;

    /**
    * 和购买种类绑定，通用即都可以减，对种类有限制
    */
    @ApiModelProperty(value="和购买种类绑定，通用即都可以减，对种类有限制")
    private String couponCategory;

    /**
    * 必须总计金额大于多少才能够使用
    */
    @ApiModelProperty(value="必须总计金额大于多少才能够使用")
    private BigDecimal couponLimit;

    @ApiModelProperty(value="")
    private Date created;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCouponCategory() {
        return couponCategory;
    }

    public void setCouponCategory(String couponCategory) {
        this.couponCategory = couponCategory == null ? null : couponCategory.trim();
    }

    public BigDecimal getCouponLimit() {
        return couponLimit;
    }

    public void setCouponLimit(BigDecimal couponLimit) {
        this.couponLimit = couponLimit;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", couponMoney=").append(couponMoney);
        sb.append(", name=").append(name);
        sb.append(", couponCategory=").append(couponCategory);
        sb.append(", couponLimit=").append(couponLimit);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}