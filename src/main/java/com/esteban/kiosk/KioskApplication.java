package com.esteban.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.crypto.Data;

import com.esteban.kiosk.model.Order;
import com.esteban.kiosk.model.OrderStatus;
import com.esteban.kiosk.model.User;
import com.esteban.kiosk.service.DatabaseService;
import com.esteban.kiosk.service.Initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.db.names.DBNameResolver;

@SpringBootApplication
public class KioskApplication implements CommandLineRunner {
	private static final Logger LOGGER= LoggerFactory.getLogger(KioskApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KioskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> argsAsList = new ArrayList<>(Arrays.asList(args));

		DatabaseService<User> userService = new DatabaseService<User>();
		Initializer.initUserMemDB(userService);

		// var or = new Order(1);
		// or.setStatus(OrderStatus.IN_PROGRESS);
		// LOGGER.info(String.format("validate cancel: %1$s", or.validateCancel()));

		var userToUpdate = userService.getFirstRecord();
		userToUpdate.setEmail("TEST@TEST.COM");
		userService.editRecord(userToUpdate);

		// To show status on the console always print DB if argument passed
		if (argsAsList.contains("--status=users")) {
			printUserTable(userService.getRecords());
		}
	}

	private void printUserTable(List<User> usersTable) {
		LOGGER.info("----------- STATUS USER TABLE ------");
		for (var rec : usersTable) {
			LOGGER.info(String.format("record %2$s: %1$s", rec.toString(), rec.getId()));
		}
	}

}
