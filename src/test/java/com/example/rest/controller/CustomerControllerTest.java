package com.example.rest.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Before;
import org.junit.Test;

import com.example.rest.dao.MockedCustomerDataAccess;
import com.example.rest.model.Customer;

public class CustomerControllerTest{
	
	CustomerController controller;
	
	String mockedCustomerName = "Mark";
	
	@Before
	public void setUp(){
		controller = new CustomerController();
		MockedCustomerDataAccess customerDataAccess = new MockedCustomerDataAccess();
		customerDataAccess.addCustomer(mockedCustomerName);
		controller.setCustomerDataAccess(customerDataAccess);
	}
	
	@Test
	public void given_a_correct_name_should_get_the_customer_entity() throws Throwable{
		Customer customer = controller.getById(mockedCustomerName);
		assertThat(customer, is(notNullValue()));
		assertThat(customer.getName(), is(mockedCustomerName));
	}
}
