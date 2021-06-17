package com.esteban.kiosk.service;

public class Helper {
    private static long baseUniqueID = 10000;
    public static long generateUniqueId() {
        baseUniqueID ++;
        return baseUniqueID;
    }    
}
