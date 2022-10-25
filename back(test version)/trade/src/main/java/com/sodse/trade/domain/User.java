package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "com-sodse-trade-domain-User")
public class User implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    @ApiModelProperty(value = "")
    private String username;

    @ApiModelProperty(value = "")
    private String password;

    @ApiModelProperty(value = "")
    private String sex;

    /**
     * 身份证
     */
    @ApiModelProperty(value = "身份证")
    private Long idCard;

    @ApiModelProperty(value = "")
    private String idImg;

    /**
     * 判断真假
     */
    @ApiModelProperty(value = "判断真假")
    private Integer flag;

    /**
     * 等级：1 普通用户\n等级：2 商家\n等级：3 管理员
     */
    @ApiModelProperty(value = "等级：1 普通用户\n等级：2 商家\n等级：3 管理员")
    private Integer level;

    /**
     * 昵称可以随意
     */
    @ApiModelProperty(value = "昵称可以随意")
    private String userNickname;

    /**
     * 头像可以随意
     */
    @ApiModelProperty(value = "头像可以随意")
    private String userImg;

    @ApiModelProperty(value = "")
    private String roles;

    @ApiModelProperty(value = "")
    private BigDecimal money;

    /**
     * 绑定银行卡号用于支付
     */
    @ApiModelProperty(value = "绑定银行卡号用于支付")
    private Long bankCard;

    /**
     * 个人或者商家的描述
     */
    @ApiModelProperty(value = "个人或者商家的描述")
    private String description;

    /**
     * 拥有优惠券的ID
     */
    @ApiModelProperty(value = "拥有优惠券的ID")
    private Long coupon;

    @ApiModelProperty(value = "")
    private String authorities;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getIdImg() {
        return idImg;
    }

    public void setIdImg(String idImg) {
        this.idImg = idImg == null ? null : idImg.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getBankCard() {
        return bankCard;
    }

    public void setBankCard(Long bankCard) {
        this.bankCard = bankCard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getCoupon() {
        return coupon;
    }

    public void setCoupon(Long coupon) {
        this.coupon = coupon;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities == null ? null : authorities.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", sex=").append(sex);
        sb.append(", idCard=").append(idCard);
        sb.append(", idImg=").append(idImg);
        sb.append(", flag=").append(flag);
        sb.append(", level=").append(level);
        sb.append(", userNickname=").append(userNickname);
        sb.append(", userImg=").append(userImg);
        sb.append(", roles=").append(roles);
        sb.append(", money=").append(money);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", description=").append(description);
        sb.append(", coupon=").append(coupon);
        sb.append(", authorities=").append(authorities);
        sb.append("]");
        return sb.toString();
    }
}