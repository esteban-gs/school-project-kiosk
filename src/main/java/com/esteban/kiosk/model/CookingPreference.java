package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

import java.util.List;

public class CookingPreference extends BaseModel {

    @Override
    public String toString() {
        return "{" +
            " description='" + getDescription() + "'" +
            ", cookingOptionId='" + getCookingOptionId() + "'" +
            ", orderItemId='" + getOrderItemId() + "'" +
            "}";
    }
    private String description;
    private long cookingOptionId; // relational
    private long orderItemId; // relational

    public CookingPreference(long id) {
        super(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCookingOptionId() {
        return cookingOptionId;
    }

    public void setCookingOptionId(long cookingOptionId) {
        this.cookingOptionId = cookingOptionId;
    }

    public long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    // methods
    public boolean validateAvailableCookingOptions(List<CookingOption> options) {
        var option = options.stream()
                .filter(o -> o.getId() == this.getCookingOptionId())
                .findFirst().orElse(null);
        if (option != null) {
            return option.isAvailable();
        }
        return false;
    }
}
