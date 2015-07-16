package com.xyzcorp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryParser {

	public static Checkout parseLine(String input) {
		String[] result = input.split("~");
		return new Checkout(result[0], result[1], LocalDate.parse(result[2]));
	}

	public static List<Checkout> parseFromScanner(Scanner scanner) {
		List<Checkout> result = new ArrayList<>();
		while (scanner.hasNext()) {
		  result.add(parseLine(scanner.nextLine()));
	    }
	    return result;
	}
}
