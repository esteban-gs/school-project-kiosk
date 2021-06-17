package com.esteban.kiosk.service;

import java.util.Locale;

import com.esteban.kiosk.model.User;
import com.github.javafaker.Faker;

public class Initializer {
    static Faker faker = new Faker(new Locale("en-US"));

    
    public static void initUserMemDB(DatabaseService<User> serv) {
        // Seed with faker service
        for(var i = 0; i <= 10; i++) {
            serv.memoryDB.add(new User(Helper.generateUniqueId(), faker.bothify("????##@gmail.com"), faker.name().firstName(), faker.name().lastName()));
        }
    }
}
