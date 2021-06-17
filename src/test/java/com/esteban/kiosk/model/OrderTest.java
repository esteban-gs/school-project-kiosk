package com.esteban.kiosk.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.esteban.kiosk.service.Helper;

import org.junit.jupiter.api.Test;

public class OrderTest {
    private final Order testOrder = new Order(Helper.generateUniqueId());
    
    @Test
    void orderStatusShouldDefaultToInactive() {
        assertTrue(testOrder.getStatus() == OrderStatus.INACTIVE);
    }

    @Test
    void validateOrderPlacePassesIfInvalidStatus() {
        assertTrue(testOrder.validateOrderPlace());
    }

    @Test
    void validateOrderPlaceFailsIfNOTInvalidStatus() {
        testOrder.setStatus(OrderStatus.DELIVERED);
        assertFalse(testOrder.validateOrderPlace());
    }
}
