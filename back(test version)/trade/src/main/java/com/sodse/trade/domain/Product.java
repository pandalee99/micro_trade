package com.sodse.trade.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Document(indexName = "product", shards = 1, replicas = 0)
@ApiModel(value = "com-sodse-trade-domain-Product")
public class Product implements Serializable {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "")
    private Long id;


//    @Field(type = FieldType.Keyword, analyzer = "ik_max_word")
    @ApiModelProperty(value = "")
    private String name;

    @ApiModelProperty(value = "")
    private BigDecimal price;

    @Field(index = false,type = FieldType.Text)
    @ApiModelProperty(value = "")
    private String mainImg;

//    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "")
    private String content;

    /**
     * 会有一个品牌表
     */
//    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "会有一个品牌表")
    private String brand;

    /**
     * 会有一个分类表
     */

    @Field(type = FieldType.Text,fielddata = true)
    @ApiModelProperty(value = "会有一个分类表")
    private String category;

    /**
     * 当库存为0时则无法购买
     */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "当库存为0时则无法购买")
    private Integer stock;

    /**
     * 判断是否为真
     */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "判断是否为真")
    private Integer flag;

    /**
     * 时间戳在创建新商品时产生
     */
    @Field(index = false,type = FieldType.Long)
    @ApiModelProperty(value = "时间戳在创建新商品时产生")
    private Date created;

    /**
     * 如手机：颜色，衣服：颜色。。。以逗号隔开
     */
    @ApiModelProperty(value = "如手机：颜色，衣服：颜色。。。以逗号隔开")
    private String properties1;

    /**
     * 如手机规格：8+128gb，衣服 S,M,L,XL,XXL 以逗号隔开。若无第二规格，则在第一个开头显示 无
     */
    @ApiModelProperty(value = "如手机规格：8+128gb，衣服 S,M,L,XL,XXL 以逗号隔开。若无第二规格，则在第一个开头显示 无")
    private String properties2;

    /**
     * 快递费
     */
    @ApiModelProperty(value = "快递费")
    private BigDecimal courierFees;

    /**
     * 属于哪一个商家
     */
    @ApiModelProperty(value = "属于哪一个商家")
    private String merchant;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg == null ? null : mainImg.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getProperties1() {
        return properties1;
    }

    public void setProperties1(String properties1) {
        this.properties1 = properties1 == null ? null : properties1.trim();
    }

    public String getProperties2() {
        return properties2;
    }

    public void setProperties2(String properties2) {
        this.properties2 = properties2 == null ? null : properties2.trim();
    }

    public BigDecimal getCourierFees() {
        return courierFees;
    }

    public void setCourierFees(BigDecimal courierFees) {
        this.courierFees = courierFees;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant == null ? null : merchant.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", mainImg=").append(mainImg);
        sb.append(", content=").append(content);
        sb.append(", brand=").append(brand);
        sb.append(", category=").append(category);
        sb.append(", stock=").append(stock);
        sb.append(", flag=").append(flag);
        sb.append(", created=").append(created);
        sb.append(", properties1=").append(properties1);
        sb.append(", properties2=").append(properties2);
        sb.append(", courierFees=").append(courierFees);
        sb.append(", merchant=").append(merchant);
        sb.append("]");
        return sb.toString();
    }
}