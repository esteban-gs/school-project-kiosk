package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

public class MenuItem extends BaseModel {

    @Override
    public String toString() {
        return "{" +
            " menuItemNumber='" + getMenuItemNumber() + "'" +
            ", price='" + getPrice() + "'" +
            ", taxRate='" + getTaxRate() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
    private String menuItemNumber;
    private double price;
    private double taxRate;
    private String name;

    public MenuItem(long id) {
        super(id);
    }

    public String getMenuItemNumber() {
        return menuItemNumber;
    }

    public void setMenuItemNumber(String menuItemNumber) {
        this.menuItemNumber = menuItemNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
