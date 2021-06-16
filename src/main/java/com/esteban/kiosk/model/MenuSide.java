package com.esteban.kiosk.model;

import com.esteban.kiosk.model.shared.BaseModel;

public class MenuSide extends BaseModel {
    private long sideId; // relation
    private long menuItemId; // relation

    public MenuSide(long id) {
        super(id);
    }

    public long getSideId() {
        return sideId;
    }

    public void setSideId(long sideId) {
        this.sideId = sideId;
    }

    public long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(long menuItemId) {
        this.menuItemId = menuItemId;
    }
}
