package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

enum AddressType {
    BILLING,
    SHIPPING
}
public class Address extends BaseModel {

    @Override
    public String toString() {
        return "{" +
            " line1='" + getLine1() + "'" +
            ", line2='" + getLine2() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", zip='" + getZip() + "'" +
            ", country='" + getCountry() + "'" +
            ", type='" + getType() + "'" +
            ", active='" + isActive() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private AddressType type;
    private boolean active;
    private long userId; // relational

    public Address(long id) {
        super(id);
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
