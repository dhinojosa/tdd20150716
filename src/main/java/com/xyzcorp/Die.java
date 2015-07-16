package com.xyzcorp;

public interface Die {

	public static final int MAX_SIDES = 6;

	public abstract int getPips();

	public abstract Die roll();

}