package com.lp.uav_weixin_back_project.uav_sale.model.dto;

public class SaleReplyDto {
    private Integer messageId;

    private Integer replyPersonId;

    private String replyMessage;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getReplyPersonId() {
        return replyPersonId;
    }

    public void setReplyPersonId(Integer replyPersonId) {
        this.replyPersonId = replyPersonId;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }
}
