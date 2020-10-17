package com.sincro.shop.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.sincro.shop.constant.CustomerType;

/**
 * @author Vidya Sagar Gupta <br />
 *         Parameterized JUnit class to test the method getTotalBillingAmount by
 *         passing different input parameters.
 */
@RunWith(value = Parameterized.class)
public class ShoppingServiceTest {

	private ShoppingService shoppingService;
	
	@Parameter(value = 0)
	public int purchaseAmount;   //input

	@Parameter(value = 1)
	public CustomerType customerType;  //input

	@Parameter(value = 2)
	public double expectedTotalBillingAmount;   //Expected output

	@Parameters(name = "Test case {index}: totalBillingAmount: {2} on purchaseAmount of {0} for customerType: {1}")
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] { 
												//Test data for Regular customer
												{ 0, CustomerType.Regular, 0},
												{ 5000, CustomerType.Regular, 5000}, 
												{ 10000, CustomerType.Regular, 9500 }, 
												{ 15000, CustomerType.Regular, 13500 },
												
												//Test data for Premium customer
												{ 0, CustomerType.Premium, 0}, 
												{ 4000, CustomerType.Premium, 3600}, 
												{ 8000, CustomerType.Premium, 7000 }, 
												{ 12000, CustomerType.Premium, 10200 },
												{ 20000, CustomerType.Premium, 15800 }
												
											});
	}

	@Before
	public void before() {
		this.shoppingService = ShoppingService.getInstance();
	}

	@Test
	public void totalBillingAmountTest() {
		double totalBillingAmount = this.shoppingService.getTotalBillingAmount(purchaseAmount, customerType);
		assertThat(totalBillingAmount, is(expectedTotalBillingAmount));
	}

}