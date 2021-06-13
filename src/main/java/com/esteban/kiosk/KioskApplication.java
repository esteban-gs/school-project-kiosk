package com.esteban.kiosk;

import com.esteban.kiosk.model.Order;
import com.esteban.kiosk.model.OrderStatus;
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
		var or = new Order(1);
		or.setStatus(OrderStatus.IN_PROGRESS);
		LOGGER.info(String.format("validate cancel: %1$s", or.validateCancel()));
		// TODO Auto-generated method stub
	}

}
