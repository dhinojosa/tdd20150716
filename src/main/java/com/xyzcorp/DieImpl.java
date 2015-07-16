package com.xyzcorp;

import java.util.Random;
import static com.google.common.base.Preconditions.*;
public class DieImpl implements Die {
	
	private Random random;
	private int pips;
	public DieImpl(Random random) {
		checkNotNull(random, "Random cannot be null.");
		this.random = random;
		this.pips = 1;
	}

	public DieImpl(int pips) {
		this.pips = pips;
	}

	/* (non-Javadoc)
	 * @see com.xyzcorp.Die#getPips()
	 */
	@Override
	public int getPips() {
		return pips;
	}

	/* (non-Javadoc)
	 * @see com.xyzcorp.Die#roll()
	 */
	@Override
	public Die roll() {
		return new DieImpl(random.nextInt(MAX_SIDES) + 1);
	}
}