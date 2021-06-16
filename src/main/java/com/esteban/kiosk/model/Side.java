package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

public class Side extends BaseModel {
    private String name;
    private double price;
    private boolean containsAllergens;

    public Side(long id, String name, double price, boolean containsAllergens) {
        super(id);
        this.name = name;
        this.price = price;
        this.containsAllergens = containsAllergens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isContainsAllergens() {
        return containsAllergens;
    }

    public void setContainsAllergens(boolean containsAllergens) {
        this.containsAllergens = containsAllergens;
    }
}
