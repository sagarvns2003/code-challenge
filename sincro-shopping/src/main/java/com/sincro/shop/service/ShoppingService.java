package com.sincro.shop.service;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.sincro.shop.constant.CustomerType;

/**
 * @author Vidya Sagar Gupta <br />
 *         This Singleton class contains the method to get the total billing
 *         amount after applying the discount.
 */
public class ShoppingService {

	private static volatile ShoppingService instance;

	// Inject discountService single instance
	private DiscountService discountService = DiscountService.getInstance();

	private ShoppingService() {
		if (Objects.nonNull(instance)) { // Prevent another instance creation form the reflection
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
	}

	// Creating the single instance of this class
	public static ShoppingService getInstance() {
		if (Objects.isNull(instance)) {
			synchronized (ShoppingService.class) {
				if (instance == null)
					instance = new ShoppingService();
			}
		}
		return instance;
	}

	// Make singleton from serialize and deserialize operation also
	protected ShoppingService readResolve() {
		return getInstance();
	}

	/**
	 * This method is to get the total billing amount after applying the calculated
	 * discount on the purchase amount for the the given customer type
	 */
	public double getTotalBillingAmount(int purchaseAmount, CustomerType customerType) {
		System.out.println("Purchase amount: " + purchaseAmount + ", for customer type: " + customerType);

		// Calculate discount
		BiFunction<Integer, CustomerType, Double> calculateDiscount = (pa, ct) -> discountService.apply(pa, ct);

		// Apply discount and get total billing amount
		Function<Double, Double> applyDiscount = (discount) -> {
			return (purchaseAmount > 0) ? (purchaseAmount - discount) : 0.0;
		};

		// Result here
		double totalBillingAmount = calculateDiscount.andThen(applyDiscount).apply(purchaseAmount, customerType);
		System.out.println("Total billing amount after discount is: " + totalBillingAmount);

		return totalBillingAmount;
	}

}