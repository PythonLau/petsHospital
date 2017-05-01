package com.coco.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
public class treat {
    private BigDecimal id;
    private String petName;
    private Date registerTime;
    private String telePhone;
    private String nickName;
    private String sickname;
    private String bedRoomName;
    private BigDecimal bedroom;
    private BigDecimal price;
    private String word;
    private Short status;
    private Date startMedicalTime;
    private Date endMedicalTime;


    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getSickname() {
        return sickname;
    }

    public void setSickname(String sickname) {
        this.sickname = sickname;
    }

    public String getBedRoomName() {
        return bedRoomName;
    }

    public void setBedRoomName(String bedRoomName) {
        this.bedRoomName = bedRoomName;
    }

    public BigDecimal getBedroom() {
        return bedroom;
    }

    public void setBedroom(BigDecimal bedroom) {
        this.bedroom = bedroom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getStartMedicalTime() {
        return startMedicalTime;
    }

    public void setStartMedicalTime(Date startMedicalTime) {
        this.startMedicalTime = startMedicalTime;
    }

    public Date getEndMedicalTime() {
        return endMedicalTime;
    }

    public void setEndMedicalTime(Date endMedicalTime) {
        this.endMedicalTime = endMedicalTime;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
