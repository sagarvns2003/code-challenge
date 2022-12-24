package vidya.code.chalenge.sincro;

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

/**
 * @author Vidya Sagar Gupta
 */
@RunWith(value = Parameterized.class)
public class DiscountServiceTest {

	private DiscountService discountService;

	@Parameter(value = 0)
	public int purchaseAmount; // input

	@Parameter(value = 1)
	public CustomerType customerType; // input

	@Parameter(value = 2)
	public double expectedDiscountAmount; // Expected output

	@Parameters(name = "Test case {index}: totalDiscount: {2} on purchaseAmount of {0} for customerType: {1}")
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] { 
			//Test data for Regular customer
			{ 0, CustomerType.Regular, 0},
			{ 5000, CustomerType.Regular, 0}, 
			{ 10000, CustomerType.Regular, 500 }, 
			{ 15000, CustomerType.Regular, 1500 },
			
			//Test data for Premium customer
			{ 0, CustomerType.Premium, 0}, 
			{ 4000, CustomerType.Premium, 400}, 
			{ 8000, CustomerType.Premium, 1000 }, 
			{ 12000, CustomerType.Premium, 1800 },
			{ 20000, CustomerType.Premium, 4200 }
			
		});
	}

	@Before
	public void before() {
		this.discountService = DiscountService.getInstance();
	}

	@Test
	public void applicableDiscountTest() {
		double applicableDiscount = this.discountService.apply(purchaseAmount, customerType);
		assertThat(applicableDiscount, is(expectedDiscountAmount));
	}
}