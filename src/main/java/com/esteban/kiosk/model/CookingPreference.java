package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

import java.util.List;

public class CookingPreference extends BaseModel {
    private String description;
    private Integer cookingOptionId; // relational
    private Integer orderItemId; // relational

    public CookingPreference(Integer id) {
        super(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCookingOptionId() {
        return cookingOptionId;
    }

    public void setCookingOptionId(Integer cookingOptionId) {
        this.cookingOptionId = cookingOptionId;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public boolean validateAvailableCookingOptions(List<CookingOption> options, CookingPreference cookingPreference) {
        var option = options.stream()
                .filter(o -> o.getId() == cookingPreference.getCookingOptionId())
                .findFirst().orElse(null);
        if (option != null) {
            return option.isAvailable();
        }
        return false;
    }
}
