package com.sodse.trade.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "com-sodse-trade-domain-ChatRecord")
public class ChatRecord implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 是自己发送为1，不是自己发送为0
     */
    @ApiModelProperty(value = "是自己发送为1，不是自己发送为0")
    private Integer isSend;

    @ApiModelProperty(value = "")
    private String createTime;

    @ApiModelProperty(value = "")
    private String content;

    @ApiModelProperty(value = "")
    private Long userId;

    /**
     * 聊天对象id
     * 每当用户发送一条信息，都会写入一次数据库，其中is_send为1表示自己发的，然后同时给被接受者反向写入id但是send值为0，表示被接收。
     * 第二，当用户删除自己的聊天框时，使用delete把该用户id和对象的id全部满足的记录删除
     */
    @ApiModelProperty(value = "聊天对象id ,每当用户发送一条信息，都会写入一次数据库，其中is_send为1表示自己发的，然后同时给被接受者反向写入id但是send值为0，表示被接收。,第二，当用户删除自己的聊天框时，使用delete把该用户id和对象的id全部满足的记录删除")
    private Long talkerId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTalkerId() {
        return talkerId;
    }

    public void setTalkerId(Long talkerId) {
        this.talkerId = talkerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isSend=").append(isSend);
        sb.append(", createTime=").append(createTime);
        sb.append(", content=").append(content);
        sb.append(", userId=").append(userId);
        sb.append(", talkerId=").append(talkerId);
        sb.append("]");
        return sb.toString();
    }
}