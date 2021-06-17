package com.esteban.kiosk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.esteban.kiosk.model.Address;
import com.esteban.kiosk.model.CookingOption;
import com.esteban.kiosk.model.CookingPreference;
import com.esteban.kiosk.model.MenuItem;
import com.esteban.kiosk.model.MenuSide;
import com.esteban.kiosk.model.Order;
import com.esteban.kiosk.model.OrderItem;
import com.esteban.kiosk.model.OrderItemStatus;
import com.esteban.kiosk.model.OrderStatus;
import com.esteban.kiosk.model.OrderingDevice;
import com.esteban.kiosk.model.Side;
import com.esteban.kiosk.model.User;
import com.github.javafaker.Faker;

public class Initializer {
    static Faker faker = new Faker(new Locale("en-US"));
    static List<OrderingDevice> devices = new ArrayList<>();
    static List<MenuItem> menuItems = new ArrayList<>();
    static List<MenuSide> menuSides = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static List<CookingPreference> cookingPreferences = new ArrayList<>();
    static List<CookingOption> cookingOptions = new ArrayList<>();
    static List<Side> sides = new ArrayList<>();
    static List<OrderItem> orderItems = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static List<Address> addresses = new ArrayList<>();

    // The DB
    public static DatabaseService<User> userServ = new DatabaseService<>();
    public static DatabaseService<Order> orderServ = new DatabaseService<>();
    public static DatabaseService<OrderingDevice> orderingDeviceServ = new DatabaseService<>();
    public static DatabaseService<MenuItem> menuItemServ = new DatabaseService<>();
    public static DatabaseService<Address> addressServ = new DatabaseService<>();
    public static DatabaseService<CookingOption> cookingOptionServ = new DatabaseService<>();
    public static DatabaseService<CookingPreference> cookingPreferenceServ = new DatabaseService<>();
    public static DatabaseService<MenuSide> menuSideServ = new DatabaseService<>();
    public static DatabaseService<OrderItem> orderItemServ = new DatabaseService<>();
    public static DatabaseService<Side> sideServ = new DatabaseService<>();

    public static void generateSeed() {
        // Ordering Device
        var device1 = new OrderingDevice(Helper.generateUniqueId());
        device1.setNumber(faker.number().numberBetween(1000, 99999));
        devices.add(device1);  
        
        // MenuItem
        var theBigHog = new MenuItem(Helper.generateUniqueId());
        theBigHog.setName("The Bib Hog");
        theBigHog.setMenuItemNumber(faker.number().digits(5));
        theBigHog.setPrice(10.00);
        theBigHog.setTaxRate(.5);

        var soggyFries = new MenuItem(Helper.generateUniqueId());
        soggyFries.setName("Soggy Fries");
        soggyFries.setMenuItemNumber(faker.number().digits(5));
        soggyFries.setPrice(5.00);
        soggyFries.setTaxRate(.5);

        var fishAndChips = new MenuItem(Helper.generateUniqueId());
        fishAndChips.setName("Fish & Chips");
        fishAndChips.setMenuItemNumber(faker.number().digits(5));
        fishAndChips.setPrice(12.00);
        fishAndChips.setTaxRate(.5);

        var theSeattleDog = new MenuItem(Helper.generateUniqueId());
        theSeattleDog.setName("The Seattle Dog");
        theSeattleDog.setMenuItemNumber(faker.number().digits(5));
        theSeattleDog.setPrice(8.00);
        theSeattleDog.setTaxRate(.5);

        menuItems.add(theBigHog);
        menuItems.add(soggyFries);
        menuItems.add(fishAndChips);
        menuItems.add(theSeattleDog);

        // Users
        var user1 = new User(Helper.generateUniqueId());
        user1.setEmail(faker.bothify("????##@gmail.com"));
        user1.setEmailConfirmed(true);
        user1.setFirstName(faker.name().firstName());
        user1.setLastName(faker.name().lastName());
        user1.setMobile(faker.phoneNumber().cellPhone());
        users.add(user1);

        // Addresses
        var address1 = new Address(Helper.generateUniqueId());
        address1.setActive(true);
        address1.setLine1(faker.address().streetAddress());
        address1.setCity(faker.address().city());
        address1.setState(faker.address().state());
        address1.setZip(faker.address().zipCode());
        address1.setUserId(user1.getId());
        addresses.add(address1);
        user1.setAddressList(addresses);

        // CookingOptions
        var cookingOption = new CookingOption(Helper.generateUniqueId(), "Well Done");
        cookingOption.setAvailable(true);
        cookingOptions.add(cookingOption);

        // Side
        var side = new Side(Helper.generateUniqueId(), "Salad", 6.00, false);
        sides.add(side);

        // MenuItemSides
        var menuItemSide = new MenuSide(Helper.generateUniqueId());
        menuItemSide.setMenuItemId(theBigHog.getId());
        menuItemSide.setSideId(side.getId());      
        menuSides.add(menuItemSide);

        // CookingPreferece
        var cookingPreference = new CookingPreference(Helper.generateUniqueId());
        cookingPreference.setCookingOptionId(cookingOption.getId());
        cookingPreference.setDescription("Decription");
        cookingPreferences.add(cookingPreference);

        // OrderItem
        var orderItem = new OrderItem(Helper.generateUniqueId());
        orderItem.setCookingPreferences(cookingPreferences);
        orderItem.setMenuItemId(theBigHog.getId());
        orderItem.setOrderCompletionMinutes(10);
        orderItem.setOrderItemStatus(OrderItemStatus.CART);
        orderItem.setQuantity(3);
        orderItem.setSubtotal(theBigHog.getPrice()*orderItem.getQuantity());
        orderItems.add(orderItem);
        
        // Order
        var order = new Order(Helper.generateUniqueId());
        order.setDeviceId(device1.getId());
        order.setNumber(faker.number().numberBetween(1000, 9999));
        order.setStatus(OrderStatus.INACTIVE);
        order.setUserId(user1.getId());

        orders.add(order);
    }

    public static void seed() {
        // Seed with faker service
        userServ.memoryDB.addAll(users);
        orderServ.memoryDB.addAll(orders);
        orderingDeviceServ.memoryDB.addAll(devices);
        menuItemServ.memoryDB.addAll(menuItems);
        addressServ.memoryDB.addAll(addresses);
        cookingOptionServ.memoryDB.addAll(cookingOptions);
        cookingPreferenceServ.memoryDB.addAll(cookingPreferences);
        menuSideServ.memoryDB.addAll(menuSides);
        orderItemServ.memoryDB.addAll(orderItems);
        sideServ.memoryDB.addAll(sides);
    }
}
