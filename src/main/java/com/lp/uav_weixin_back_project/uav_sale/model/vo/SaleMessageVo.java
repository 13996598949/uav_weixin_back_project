package com.lp.uav_weixin_back_project.uav_sale.model.vo;

import com.lp.uav_weixin_back_project.model.Model;

import java.util.Date;

public class SaleMessageVo extends Model {
    private String personName;

    private String header;

    private String message;

    private String replyPersonName;

    private String replyHeader;

    private String replyMessage;

    private Date messageTime;

    private Date replyTime;

    private String messageTimeStr;

    private String replyTimeStr;

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getMessageTimeStr() {
        return messageTimeStr;
    }

    public void setMessageTimeStr(String messageTimeStr) {
        this.messageTimeStr = messageTimeStr;
    }

    public String getReplyTimeStr() {
        return replyTimeStr;
    }

    public void setReplyTimeStr(String replyTimeStr) {
        this.replyTimeStr = replyTimeStr;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReplyPersonName() {
        return replyPersonName;
    }

    public void setReplyPersonName(String replyPersonName) {
        this.replyPersonName = replyPersonName;
    }

    public String getReplyHeader() {
        return replyHeader;
    }

    public void setReplyHeader(String replyHeader) {
        this.replyHeader = replyHeader;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }
}