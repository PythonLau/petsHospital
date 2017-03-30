package com.coco.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbMedical {
    private BigDecimal id;

    private BigDecimal petid;

    private Long officeid;

    private Date registertime;

    private Short status;

    private String recipe;

    private BigDecimal price;

    private BigDecimal doctorid;

    private Date created;

    private Date updated;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getPetid() {
        return petid;
    }

    public void setPetid(BigDecimal petid) {
        this.petid = petid;
    }

    public Long getOfficeid() {
        return officeid;
    }

    public void setOfficeid(Long officeid) {
        this.officeid = officeid;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe == null ? null : recipe.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(BigDecimal doctorid) {
        this.doctorid = doctorid;
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
}