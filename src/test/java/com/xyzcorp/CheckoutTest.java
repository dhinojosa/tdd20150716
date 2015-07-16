package com.xyzcorp;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.assertj.core.api.Assertions.*;

public class CheckoutTest {

	@Test
	@Category(value = {UnitTest.class})
	public void testPunishmentMonths() {
		Checkout checkout = new Checkout("Sai Parab", 
				"Shoes of the Northwest", LocalDate.of(2010, 1, 14));
		LocalDate fakeTodaysDate = LocalDate.of(2015, 7, 16);
		assertThat(checkout.getPunishmentMonths(2, fakeTodaysDate))
		      .isEqualTo(64L);		
	}
}
