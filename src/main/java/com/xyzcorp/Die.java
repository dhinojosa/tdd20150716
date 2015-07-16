package com.xyzcorp;

import java.util.Random;

public class Die {
	
	private Random random;
	private int pips;
	
	public Die(Random random) {
		this.random = random;
		this.pips = 1;
	}

	public Die(int pips) {
		this.pips = pips;
	}

	public int getPips() {
		return pips;
	}

	public Die roll() {
		return new Die(random.nextInt());
	}
}