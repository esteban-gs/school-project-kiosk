package com.esteban.kiosk.service;

import com.esteban.kiosk.KioskApplication;
import com.esteban.kiosk.model.User;
import com.github.javafaker.Faker;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserService {
    private static final Logger LOGGER= LoggerFactory.getLogger(KioskApplication.class);
    public static List<User> userMemDB = new ArrayList<User>();
    static Faker faker = new Faker(new Locale("en-US"));

    public static void initUserMemDB() {
        // Seed with faker service
        for(var i = 0; i <= 10; i++) {
            userMemDB.add(new User(Helper.generateUniqueId(), faker.bothify("????##@gmail.com"), faker.name().firstName(), faker.name().lastName()));
        }
    }
    public static List<User> getUsers() {
        return userMemDB;
    }

    public static User getUserById(int id) {
        return userMemDB.get(id);
    }

    public static void editUser(User user) {
        var dbRecord = userMemDB.stream()
                .filter(u -> u.getId() == user.getId())
                .findFirst().orElse(null);
        LOGGER.info(String.format("record to Update: %1$s", dbRecord));
        dbRecord.setFirstName(user.getFirstName());
        var recordIndex = userMemDB.indexOf(dbRecord);
        var result = userMemDB.set(recordIndex, user);

        LOGGER.info(String.format("Updated: %1$s", result));
    }
}
