package com.sincro.shop.constant;

import static org.junit.Assert.assertTrue;

import java.util.stream.Stream;

import org.junit.Test;

public class CustomerTypeTest {

	@Test
	public void totalCustomerTypeTest() {
		int expectedCustomerType = 2;
		assertTrue(expectedCustomerType == Stream.of(CustomerType.values()).count());
	}

	@Test
	public void regularCustomerTypeTest() {
		String expectedCustomerType_Regular = "Regular";
		assertTrue(Stream.of(CustomerType.values())
				.anyMatch(customerType -> customerType.name().equals(expectedCustomerType_Regular)));
	}

	@Test
	public void premiumCustomerTypeTest() {
		String expectedCustomerType_Premium = "Premium";
		assertTrue(Stream.of(CustomerType.values())
				.anyMatch(customerType -> customerType.name().equals(expectedCustomerType_Premium)));
	}
}