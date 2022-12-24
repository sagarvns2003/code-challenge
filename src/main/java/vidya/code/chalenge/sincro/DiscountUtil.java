package vidya.code.chalenge.sincro;

public class DiscountUtil {

	/**
	 * Method to calculate discount for Regular customer
	 */
	public static double getRegularCustomerDiscount(int purchaseAmount) {
		if (purchaseAmount <= 5000)
			return 0;
		else if (purchaseAmount <= 10000)
			return (0.1 * (purchaseAmount - 5000));
		else
			return ((0.2 * (purchaseAmount - 10000)) + (0.1 * 5000));
	}

	/**
	 * Method to calculate discount for Premium customer
	 */
	public static double getPremiumCustomerDiscount(int purchaseAmount) {
		if (purchaseAmount <= 4000)
			return (0.1 * purchaseAmount);
		else if (purchaseAmount <= 8000) {
			int range2 = (purchaseAmount - 4000);
			int range1 = (purchaseAmount - range2);
			return ((0.15 * range2) + (0.1 * range1));
		} else if (purchaseAmount <= 12000) {
			int range3 = (purchaseAmount - 8000);
			int range2 = ((purchaseAmount - range3) - 4000);
			int range1 = (purchaseAmount - (range3 + range2));
			return ((0.2 * range3) + (0.15 * range2) + (0.1 * range1));
		} else {
			int range4 = (purchaseAmount - 12000);
			int range3 = ((purchaseAmount - range4) - 8000);
			int range2 = ((purchaseAmount - (range4 + range3)) - 4000);
			int range1 = (purchaseAmount - (range4 + range3 + range2));
			return ((0.3 * range4) + (0.2 * range3) + (0.15 * range2) + (0.1 * range1));
		}
	}
}