package com.coco.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbPackage {
    private BigDecimal id;

    private String name;

    private BigDecimal price;

    private BigDecimal normaldiscount;

    private BigDecimal memberdiscount;

    private String introduction;

    private Short status;

    private String image;

    private Date created;

    private Date updated;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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

    public BigDecimal getNormaldiscount() {
        return normaldiscount;
    }

    public void setNormaldiscount(BigDecimal normaldiscount) {
        this.normaldiscount = normaldiscount;
    }

    public BigDecimal getMemberdiscount() {
        return memberdiscount;
    }

    public void setMemberdiscount(BigDecimal memberdiscount) {
        this.memberdiscount = memberdiscount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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