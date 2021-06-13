package com.esteban.kiosk.service;

import com.esteban.kiosk.KioskApplication;
import com.esteban.kiosk.model.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final Logger LOGGER= LoggerFactory.getLogger(KioskApplication.class);
    List<User> userMemDB = new ArrayList<User>();

    public UserService() {
        this.initUserMemDB();
    }

    private void initUserMemDB() {
        userMemDB.add(new User(1, "peter@test.com", "peter", "parker"));
        userMemDB.add(new User(2, "john@test.com", "john", "Garcia"));
        userMemDB.add(new User(3, "muhammad@test.com", "Muhammad", "Smith"));
        userMemDB.add(new User(4, "maria@test.com", "Maria", "Jane"));
    }
    public List<User> getUsers() {
        return userMemDB;
    }

    public User getUserById(int id) {
        return userMemDB.get(id);
    }

    public void editUser(User user) {
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
