package com.coco.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbAdopt {
    private BigDecimal id;

    private BigDecimal fosteruserid;

    private BigDecimal adoptuserid;

    private BigDecimal adoptpetid;

    private String telephone;

    private String address;

    private Short status;

    private Date created;

    private Date updated;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getFosteruserid() {
        return fosteruserid;
    }

    public void setFosteruserid(BigDecimal fosteruserid) {
        this.fosteruserid = fosteruserid;
    }

    public BigDecimal getAdoptuserid() {
        return adoptuserid;
    }

    public void setAdoptuserid(BigDecimal adoptuserid) {
        this.adoptuserid = adoptuserid;
    }

    public BigDecimal getAdoptpetid() {
        return adoptpetid;
    }

    public void setAdoptpetid(BigDecimal adoptpetid) {
        this.adoptpetid = adoptpetid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
}