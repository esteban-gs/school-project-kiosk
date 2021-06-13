package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

public class MenuSide extends BaseModel {
    private Integer sideId; // relation
    private Integer menuItemId; // relation

    public MenuSide(Integer id) {
        super(id);
    }

    public Integer getSideId() {
        return sideId;
    }

    public void setSideId(Integer sideId) {
        this.sideId = sideId;
    }

    public Integer getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }
}
