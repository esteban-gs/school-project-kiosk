package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

public class OrderingDevice extends BaseModel {
    private Integer number;

    public OrderingDevice(long id) {
        super(id);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
