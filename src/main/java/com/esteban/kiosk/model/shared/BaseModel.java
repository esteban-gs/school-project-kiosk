package com.esteban.kiosk.model.shared;

public class BaseModel implements IBaseModel{
    private long id;

    public BaseModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
