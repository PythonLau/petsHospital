package com.coco.pojo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class adoptPet {
    BigDecimal fosterId;
    BigDecimal petId;
    String name;
    String contacts;
    String address;
    String telePhone;
    String image;

    public BigDecimal getFosterId() {
        return fosterId;
    }

    public void setFosterId(BigDecimal fosterId) {
        this.fosterId = fosterId;
    }

    public BigDecimal getPetId() {
        return petId;
    }

    public void setPetId(BigDecimal petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
