package com.xyzcorp;

import java.time.LocalDate;
import java.time.Period;

public class Checkout {

	private String name;
	private String title;
	private LocalDate checkoutDate;

	public Checkout(String name, String title, LocalDate checkoutDate) {
		this.name = name;
		this.title = title;
		this.checkoutDate = checkoutDate;
	}
	

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}


	public long getPunishmentMonths(int graceMonths, 
			                        LocalDate todaysDate) {
		return Period.between(checkoutDate, todaysDate)
				.toTotalMonths() - graceMonths;
	}

}
