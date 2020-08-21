package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.model.Customer;

@SpringBootTest
class HomeLoanApplicationTests {

	@Test
	void registerCustomer() {
		
		Customer customer = new Customer();
		customer.setCustomerCity("Mohali");
		customer.setCustomerdateOfBirth(LocalDate.of(1999, 07, 17));
	}

}
