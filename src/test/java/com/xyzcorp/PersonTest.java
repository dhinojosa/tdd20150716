package com.xyzcorp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PersonTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@Test
	@Category(value = {UnitTest.class})
	public void testPersonFullName() {
		Person person = new Person("Ken", "Doll");  //Subject Under Test
		assertThat(person.getFullName(), is("Ken Doll"));
	}
	
	@Test
	public void testPersonFullNameWithAnotherName() {
		Person person = new Person("Lala", "Simpson");
		assertThat(person.getFullName(), is("Lala Simpson"));
	}
	
	@After
	public void cleanup() {
		System.out.println("Clean up after the test");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
}
