package com.coco.pojo;


import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/28 0028.
 */
public class medicalRecord {
    private BigDecimal id;
    private BigDecimal medicalId;
    private String sickName;
    private String recipe;
    private String room;
    private Integer needdays;
    private BigDecimal price;
    private Short status;
    private String created;
    private String updated;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(BigDecimal medicalId) {
        this.medicalId = medicalId;
    }

    public String getSickName() {
        return sickName;
    }

    public void setSickName(String sickName) {
        this.sickName = sickName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getNeeddays() {
        return needdays;
    }

    public void setNeeddays(Integer needdays) {
        this.needdays = needdays;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
