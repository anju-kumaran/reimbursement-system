package com.example.emailAPI;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@Slf4j
@SpringBootTest
class EmailApiApplicationTests {

	@Autowired
	EmailApiApplication emailApi;

	@Test
	void contextLoads() {
	}


	@Test
	public void shouldThrowAddressException() {
		AddressException ae = Assertions.assertThrows(AddressException.class, () -> {

			emailApi.sendEmailToEmployee(null);
		});

		log.info("message :" + ae.getMessage());

		Assertions.assertEquals("Email id cannot be null", ae.getMessage(), "Method didn't throw with null parameter");
	}



	@Test
	public void shouldSendEmailToEmployee() throws MessagingException, IOException {
		String message = emailApi.sendEmailToEmployee("anju.naduth@gmail.com");

		Assertions.assertNotNull(message);
		log.info("Message is: "+message);
		Assertions.assertEquals("Email sent successfully", message, "Email sent successfully");

	}


}
