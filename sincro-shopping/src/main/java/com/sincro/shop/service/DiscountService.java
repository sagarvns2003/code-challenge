package com.sincro.shop.service;

import java.util.Objects;
import java.util.function.BiFunction;

import com.sincro.shop.constant.CustomerType;
import com.sincro.shop.util.DiscountUtil;

/**
 * @author Vidya Sagar Gupta <br />
 *         This Singleton class contains the method to get the discount on the
 *         purchase amount for the the given customer type.
 */
public class DiscountService implements BiFunction<Integer, CustomerType, Double> {

	private static volatile DiscountService instance;

	private DiscountService() {
		if (Objects.nonNull(instance)) { // Prevent another instance creation form the reflection
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
	}

	// Creating the single instance of this class
	public static DiscountService getInstance() {
		if (Objects.isNull(instance)) {
			synchronized (DiscountService.class) {
				if (instance == null)
					instance = new DiscountService();
			}
		}
		return instance;
	}

	// Make singleton from serialize and deserialize operation also
	protected DiscountService readResolve() {
		return getInstance();
	}

	@Override
	public Double apply(Integer purchaseAmount, CustomerType customerType) {
		double discount = 0;
		if (customerType == CustomerType.Regular)
			discount = DiscountUtil.getRegularCustomerDiscount(purchaseAmount);
		else if (customerType == CustomerType.Premium)
			discount = DiscountUtil.getPremiumCustomerDiscount(purchaseAmount);

		System.out.println("Applicable discount is: " + discount);
		return discount;
	}

}