package com.xyzcorp;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Assertions.*;

public class LibraryParserTest {
   
	@Test
	@Category(value={UnitTest.class})
	public void testASimpleLine() {
		String input = "Mimansha Bhargav~Lost Symbol~2015-01-05";
		Checkout checkout = LibraryParser.parseLine(input);
		assertThat(checkout.getName()).isEqualTo("Mimansha Bhargav");
		assertThat(checkout.getTitle()).isEqualTo("Lost Symbol");
		assertThat(checkout.getCheckoutDate())
		    .isEqualTo(LocalDate.parse("2015-01-05"));
	}
	
	@Test
	@Category(value={UnitTest.class})
	public void testParseFromInputStream() {
		String input = "Mimansha Bhargav~Lost Symbol~2015-01-05\n" +
	                   "Queenie Lui~Fantastic Four~2013-05-19";
		List<Checkout> checkouts = 
				LibraryParser.parseFromScanner(new Scanner(input));
		assertThat(checkouts).hasSize(2);
	}
	
	
	@Test
	@Category(value={IntegrationTest.class})
	public void testIntegrationTestFromProject() {
	    String name = "/library.txt";
		InputStream input = getClass().getResourceAsStream(name);
		List<Checkout> checkouts = 
				LibraryParser.parseFromScanner(new Scanner(input));
		assertThat(checkouts).hasSize(3);
		assertThat(checkouts.get(2).getTitle())
		       .isEqualTo("Beautiful Flowers");
	}
}
