package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

public class CookingOption extends BaseModel {
    private String name;
    private boolean available;

    public CookingOption(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
