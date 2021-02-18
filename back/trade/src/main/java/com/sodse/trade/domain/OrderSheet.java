package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "com-sodse-trade-domain-OrderSheet")
public class OrderSheet implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    @ApiModelProperty(value = "")
    private Long userId;

    @ApiModelProperty(value = "")
    private Long productId;

    /**
     * 收件人
     */
    @ApiModelProperty(value = "收件人")
    private String name;

    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private Integer phone;

    @ApiModelProperty(value = "")
    private String address;

    /**
     * 已下单,未支付，支付之后把默认值改为已支付且待收货
     */
    @ApiModelProperty(value = "已下单,未支付，支付之后把默认值改为已支付且待收货")
    private String state;

    /**
     * 关于该订单的评论的文字
     */
    @ApiModelProperty(value = "关于该订单的评论的文字")
    private String commentWord;

    /**
     * 评论的图片，可能有可能无
     */
    @ApiModelProperty(value = "评论的图片，可能有可能无")
    private String commentImg;

    /**
     * 购买时候的备注
     */
    @ApiModelProperty(value = "购买时候的备注")
    private String note;

    /**
     * 快递费
     */
    @ApiModelProperty(value = "快递费")
    private String courier;

    /**
     * 购买的数量
     */
    @ApiModelProperty(value = "购买的数量")
    private Integer amount;

    /**
     * 总金额
     */
    @ApiModelProperty(value = "总金额")
    private BigDecimal sumMoney;

    @ApiModelProperty(value = "")
    private String productProperties;

    @ApiModelProperty(value = "")
    private String time;

    @ApiModelProperty(value = "")
    private String productName;

    @ApiModelProperty(value = "")
    private String productImg;

    @ApiModelProperty(value = "")
    private BigDecimal productPrice;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCommentWord() {
        return commentWord;
    }

    public void setCommentWord(String commentWord) {
        this.commentWord = commentWord == null ? null : commentWord.trim();
    }

    public String getCommentImg() {
        return commentImg;
    }

    public void setCommentImg(String commentImg) {
        this.commentImg = commentImg == null ? null : commentImg.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier == null ? null : courier.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(String productProperties) {
        this.productProperties = productProperties == null ? null : productProperties.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", productId=").append(productId);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", state=").append(state);
        sb.append(", commentWord=").append(commentWord);
        sb.append(", commentImg=").append(commentImg);
        sb.append(", note=").append(note);
        sb.append(", courier=").append(courier);
        sb.append(", amount=").append(amount);
        sb.append(", sumMoney=").append(sumMoney);
        sb.append(", productProperties=").append(productProperties);
        sb.append(", time=").append(time);
        sb.append(", productName=").append(productName);
        sb.append(", productImg=").append(productImg);
        sb.append(", productPrice=").append(productPrice);
        sb.append("]");
        return sb.toString();
    }
}