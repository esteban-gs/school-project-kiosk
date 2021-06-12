package com.esteban.kiosk;

import com.esteban.kiosk.model.User;
import com.esteban.kiosk.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KioskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KioskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserService us = new UserService();
		us.editUser(new User(1, "newName"));
		if (args.length > 0) {
			for (String arg : args) {
				System.out.println(arg);				
			}
		} else {
		}
		// System.exit(0);	
	}

}
