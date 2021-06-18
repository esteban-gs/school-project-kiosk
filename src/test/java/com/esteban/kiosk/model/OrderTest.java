package com.esteban.kiosk.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.esteban.kiosk.service.Helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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

    @ParameterizedTest
    @EnumSource(value = OrderStatus.class, names = {
        "PLACED",
        "IN_PROGRESS",
        "READY_FOR_SERVE"
    })
    void validateCancelOrderPassesUnderAllowedStatuses(OrderStatus status) {
        testOrder.setStatus(status);
        assertTrue(testOrder.validateCancel());
    }

    @ParameterizedTest
    @EnumSource(value = OrderStatus.class, names = {
        "INACTIVE",
        "DELIVERED",
        "CANCELED"
    })
    void validateCancelOrderFailsUnderCertainStatuses(OrderStatus status) {
        testOrder.setStatus(status);
        assertFalse(testOrder.validateCancel());
    }

    @Test
    void cancelOrderChangesStatusToCancel() {
        testOrder.setStatus(OrderStatus.INACTIVE);
        testOrder.cancel();
        assertTrue(testOrder.getStatus() == OrderStatus.CANCELED);
        assertTrue(testOrder.getStatus() != OrderStatus.DELIVERED);
    }
}
