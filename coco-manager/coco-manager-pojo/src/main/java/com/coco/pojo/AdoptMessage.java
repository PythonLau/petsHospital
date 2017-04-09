package com.coco.pojo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
public class AdoptMessage {
    BigDecimal adoptId;
    String name;
    String contacts;
    String telePhone;
    String address;

    public BigDecimal getAdoptId() {
        return adoptId;
    }

    public void setAdoptId(BigDecimal adoptId) {
        this.adoptId = adoptId;
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

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
