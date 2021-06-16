package com.esteban.kiosk.service;

import com.esteban.kiosk.KioskApplication;
import com.esteban.kiosk.model.User;
import com.github.javafaker.Faker;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
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

    public static User getUserById(long id) {
        User dbRecord = userMemDB.stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElse(null);
        LOGGER.info(String.format("record %2$s located: %1$s", dbRecord, id));
        return userMemDB.get(userMemDB.indexOf(dbRecord));
    }

    public static User getFirstUser() {
        userMemDB.sort(Comparator.comparing(User::getId));
        var firstRecordInSortedList = userMemDB.get(0);
        LOGGER.info(String.format("getFirstUser: %1$s", firstRecordInSortedList, userMemDB));
        return firstRecordInSortedList;
    }

    public static void editUser(User user) {
        var dbRecord = getUserById(user.getId());
        LOGGER.info(String.format("record to Update: %1$s", dbRecord));
        var recordIndex = userMemDB.indexOf(dbRecord);
        var result = userMemDB.set(recordIndex, user);

        LOGGER.info(String.format("Updated: %1$s", result));
    }
}
