package com.esteban.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.esteban.kiosk.model.*;
import com.esteban.kiosk.service.Initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KioskApplication implements CommandLineRunner {
	private static final Logger LOGGER= LoggerFactory.getLogger(KioskApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KioskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> argsAsList = new ArrayList<>(Arrays.asList(args));

		// Put some seed records
		Initializer.generateSeed();
		Initializer.seed();

		// To show status on the console always print DB if argument passed
		if (argsAsList.contains("--status=users")) {
			printUserTable(Initializer.userServ.getRecords());
		}

		if (argsAsList.contains("--status=orders")) {
			printOrderTable(Initializer.orderServ.getRecords());
		}

		if (argsAsList.contains("--status=all")) {
			printUserTable(Initializer.userServ.getRecords());
			printOrderTable(Initializer.orderServ.getRecords());
		}
	}

	private void printOrderTable(List<Order> records) {
		LOGGER.info("----------- STATUS Order TABLE ------");
		for (var rec : records) {
			LOGGER.info(String.format("record %2$s: %1$s", rec.toString(), rec.getId()));
		}
	}

	private void printUserTable(List<User> usersTable) {
		LOGGER.info("----------- STATUS USER TABLE ------");
		for (var rec : usersTable) {
			LOGGER.info(String.format("record %2$s: %1$s", rec.toString(), rec.getId()));
		}
	}

}
