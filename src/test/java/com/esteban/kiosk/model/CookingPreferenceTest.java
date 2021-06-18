package com.esteban.kiosk.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.esteban.kiosk.service.Helper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;


@TestMethodOrder(OrderAnnotation.class)
public class CookingPreferenceTest {
    private static final CookingPreference cookingPreference = new CookingPreference(Helper.generateUniqueId());
    private static final List<CookingPreference> cookingPreferences = new ArrayList<>();
    private static final CookingOption cookingOption = new CookingOption(Helper.generateUniqueId(), "Well Done");
    private static final List<CookingOption> cookingOptions = new ArrayList<>();
    private static final MenuItem menuItem = new MenuItem(Helper.generateUniqueId());
    private static final OrderItem orderItem = new OrderItem(Helper.generateUniqueId());

    @BeforeAll
    static void beforeAll() {
        cookingOption.setAvailable(true);
        menuItem.setMenuItemNumber("11111");
        menuItem.setName("The Big Smack Sandwhich");
        menuItem.setPrice(10.00);
        menuItem.setTaxRate(.7);
        orderItem.setMenuItemId(menuItem.getId());
        
        cookingOptions.add(cookingOption);
        cookingPreference.setCookingOptionId(cookingOption.getId());
        cookingPreference.setDescription("blah");
        cookingPreference.setOrderItemId(orderItem.getId());
        cookingPreferences.add(cookingPreference);
        orderItem.setCookingPreferences(cookingPreferences);

        System.out.println(cookingPreferences);
        System.out.println(cookingOptions);
    }

    @Test
    @Order(1)
    public void validateAvailableCookingOptionsPasses() {
        assertTrue(cookingPreference.validateAvailableCookingOptions(cookingOptions));
    }

    @Test
    @Order(2)
    public void validateUNAvailableCookingOptionsFails() {
        cookingOptions.remove(cookingOption);
        cookingOptions.add(new CookingOption(Helper.generateUniqueId(), "fakeOpt"));
        assertFalse(cookingPreference.validateAvailableCookingOptions(cookingOptions));
    }
}
