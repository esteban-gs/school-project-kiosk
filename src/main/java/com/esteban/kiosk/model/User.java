package com.esteban.kiosk.model;
import com.esteban.kiosk.model.shared.BaseModel;
import com.esteban.kiosk.service.Helper;

import java.util.List;

public class User extends BaseModel {

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", emailConfirmed='" + isEmailConfirmed() + "'" +
            ", addressList='" + getAddressList() + "'" +
            "}";
    }
    public User(long id, String email, String firstName, String lastName) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
        super(Helper.generateUniqueId());
    }

    public User(long id, String email, String firstName, String lastName, String mobile, boolean emailConfirmed, List<Address> addressList) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.emailConfirmed = emailConfirmed;
        this.addressList = addressList;
    }

    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private boolean emailConfirmed;
    private List<Address> addressList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
