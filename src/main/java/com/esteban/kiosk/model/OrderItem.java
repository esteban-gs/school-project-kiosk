package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

import java.util.List;

public class OrderItem extends BaseModel {
    private long menuItemId;
    private Integer quantity;
    private double subtotal;
    private OrderItemStatus orderItemStatus;
    private Integer orderCompletionMinutes;
    private long orderId; // relation
    private List<CookingPreference> cookingPreferences;

    public OrderItem(long id) {
        super(id);
        setOrderItemStatus(OrderItemStatus.INACTIVE);
    }

    public long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public OrderItemStatus getStatus() {
        return orderItemStatus;
    }

    public void setStatus(OrderItemStatus orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public Integer getOrderCompletionMinutes() {
        return orderCompletionMinutes;
    }

    public void setOrderCompletionMinutes(Integer orderCompletionMinutes) {
        this.orderCompletionMinutes = orderCompletionMinutes;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public OrderItemStatus getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(OrderItemStatus orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public List<CookingPreference> getCookingPreferences() {
        return cookingPreferences;
    }

    public void setCookingPreferences(List<CookingPreference> cookingPreferences) {
        this.cookingPreferences = cookingPreferences;
    }
}
