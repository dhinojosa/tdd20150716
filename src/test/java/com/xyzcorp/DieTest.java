package com.xyzcorp;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.mockito.Mockito.*;
public class DieTest {
    
	@Test
	@Category(value = {UnitTest.class})
	public void defaultShouldBe1() {
		Random randomStub = new Random() {
			@Override
			public int nextInt() {
               return 4;	
            }
		};
		
		Die die = new Die(randomStub);
		assertThat(die.getPips(), is(1));
	}
	
	@Test
	@Category(value = {UnitTest.class})
	public void basicRoll() {
		Random randomStub = new Random() {
			@Override
			public int nextInt() {
               return 4;	
            }
		};
		
		Die die = new Die(randomStub);
		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips(), is(4));
	}
	
	@Test
	@Category(value = {UnitTest.class})
	public void basicRollWithAMock() {
		//Creating the mock
		Random randomMock = mock(Random.class);
		
		//Expectation - Rehearsal
		when(randomMock.nextInt()).thenReturn(1);
		
		//Subject under test
		Die die = new Die(randomMock);
		
		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips(), is(1));
	}
	
	@Test
	@Category(value = {IntegrationTest.class})
	public void dieIntegrationTest() {
	    Die die = new Die(new Random());
	    for (int i = 0; i < 10000; i++) {
	    	Die rolledDie = die.roll();
	    	assertThat(rolledDie.getPips(), is(greaterThan(0)));
	    	assertThat(rolledDie.getPips(), is(lessThan(7)));
	    }
	}
}













