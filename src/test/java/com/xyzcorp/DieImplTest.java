package com.xyzcorp;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.mockito.Mockito.*;

public class DieImplTest {

	@Test
	@Category(value = { UnitTest.class })
	public void defaultShouldBe1() {
		Random randomStub = new Random() {
			@Override
			public int nextInt(int bound) {
				return 4;
			}
		};

		Die die = new DieImpl(randomStub);
		assertThat(die.getPips()).isEqualTo(1);
	}

	@Test
	@Category(value = { UnitTest.class })
	public void basicRoll() {
		Random randomStub = new Random() {
			@Override
			public int nextInt(int bound) {
				return 4;
			}
		};

		Die die = new DieImpl(randomStub);
		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips()).isEqualTo(5);
	}

	@Test
	@Category(value = { UnitTest.class })
	public void basicRollWithAMock() {
		// Creating the mock
		Random randomMock = mock(Random.class);

		// Expectation - Rehearsal
		when(randomMock.nextInt(Die.MAX_SIDES)).thenReturn(1);

		// Subject under test
		Die die = new DieImpl(randomMock);

		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips()).isEqualTo(1);
	}

	@Test
	@Category(value = { IntegrationTest.class })
	public void dieIntegrationTest() {
		Die die = new DieImpl(new Random());
		for (int i = 0; i < 10000; i++) {
			Die rolledDie = die.roll();
			assertThat(rolledDie.getPips()).
			         isGreaterThan(0).
			         isLessThan(7);
		}
	}

	@Test
	@Category(value = { UnitTest.class })
	public void bugFix4003() {
		// Creating the mock
		Random randomMock = mock(Random.class);

		// Expectation - Rehearsal
		when(randomMock.nextInt(Die.MAX_SIDES)).thenReturn(4);

		// Subject under test
		Die die = new DieImpl(randomMock);

		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips()).isEqualTo(5);
	}
	
	@Test
	@Category(value = { UnitTest.class })
	public void bugFix4003WithZero() {
		// Creating the mock
		Random randomMock = mock(Random.class);

		// Expectation - Rehearsal
		when(randomMock.nextInt(Die.MAX_SIDES)).thenReturn(0);

		// Subject under test
		Die die = new DieImpl(randomMock);

		Die rolledDie = die.roll();
		assertThat(rolledDie.getPips()).isEqualTo(1);
	}
	
	@Test
	@Category(value = { UnitTest.class })
	public void dieShouldNotAcceptANull() {
		try {
		   new DieImpl(null);
		   fail("If we reach this point in the code, "
		   		+ "something bad happend");
		} catch (NullPointerException e) {
			assertThat(e).hasMessage("Random cannot be null.");
		}
	}
}
