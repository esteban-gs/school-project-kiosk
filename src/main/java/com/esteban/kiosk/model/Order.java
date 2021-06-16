package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

public class Order extends BaseModel {
    private Integer number;
    // private Integer paymentId; // not dealing with payment
    private OrderStatus status;
    private long userId;
    private long deviceId;

    public Order(long id) {
        super(id);
        this.setStatus(OrderStatus.INACTIVE);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    // methods //

    public void assignOwner(long userId) {
        this.setUserId(userId);
    }

    public boolean validateOrderPlace() {
        return this.getStatus() == OrderStatus.INACTIVE;
    }

    public boolean validateCancel() {
        return this.getStatus() != OrderStatus.CANCELED
                ? this.getStatus() != OrderStatus.INACTIVE
                : this.getStatus() != OrderStatus.DELIVERED;
    }

    public void cancel() {
        this.setStatus(OrderStatus.CANCELED);
    }
}
