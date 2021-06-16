package com.esteban.kiosk.service;

import java.time.Instant;

public class Helper {
    public static long generateUniqueId() {
        return Instant.now().toEpochMilli();
    }    
}
