package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TennisGameTest {

	@Test
	@Category(value = { UnitTest.class })
	public void testBeginGame() {
		TennisGame tennisGame = new TennisGame();
		assertThat(tennisGame.getScore(), is("Love All"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testPlayer1Point() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player1Point();
		assertThat(tennisGame.getScore(), is("Fifteen Love"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testPlayer1Point10x() {
		TennisGame tennisGame = new TennisGame();
        for (int i = 0; i < 10; i++) {
		   tennisGame.player1Point();
		   tennisGame.player2Point();
        }
		assertThat(tennisGame.getScore(), is("Deuce"));
	}
	
	@Test
	@Category(value = { UnitTest.class })
	public void testPlayer2Point() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		assertThat(tennisGame.getScore(), is("Love Fifteen"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testAFewBouts() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		assertThat(tennisGame.getScore(), is("Thirty Fifteen"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testSomeoneReached40() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player2Point();
		assertThat(tennisGame.getScore(), is("Fifteen Forty"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testDeuce() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		assertThat(tennisGame.getScore(), is("Deuce"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testThirtyAll() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player1Point();
		assertThat(tennisGame.getScore(), is("Thirty All"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testFifteenAll() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		assertThat(tennisGame.getScore(), is("Fifteen All"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testInitialAdvantage() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		assertThat(tennisGame.getScore(), is("Advantage Player 1"));
	}

	@Test
	@Category(value = { UnitTest.class })
	public void testAdvantageTakenAway() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		assertThat(tennisGame.getScore(), is("Deuce"));
	}
	
	@Test
	@Category(value = { UnitTest.class })
	public void testAdvantageRegained() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player1Point();
		assertThat(tennisGame.getScore(), is("Advantage Player 1"));
	}
	
	@Test
	@Category(value = { UnitTest.class })
	public void testAdvantageTakenByPlayer2() {
		TennisGame tennisGame = new TennisGame();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player2Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		tennisGame.player1Point();
		tennisGame.player2Point();
		tennisGame.player2Point();
		assertThat(tennisGame.getScore(), is("Advantage Player 2"));
	}
}
