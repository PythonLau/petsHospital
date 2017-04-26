package com.coco.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbMedicalDetail {
    private BigDecimal id;

    private BigDecimal medicalid;

    private String sickname;

    private BigDecimal room;

    private Integer needdays;

    private BigDecimal price;

    private Short status;

    private Date created;

    private Date updated;

    private String recipe;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(BigDecimal medicalid) {
        this.medicalid = medicalid;
    }

    public String getSickname() {
        return sickname;
    }

    public void setSickname(String sickname) {
        this.sickname = sickname == null ? null : sickname.trim();
    }

    public BigDecimal getRoom() {
        return room;
    }

    public void setRoom(BigDecimal room) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe == null ? null : recipe.trim();
    }
}