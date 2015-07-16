package com.xyzcorp;

public class TennisGame {
	private String[] scoreVals = 
			new String[] { "Love", "Fifteen", "Thirty", "Forty"};

	private int player1;
	private int player2;

	public TennisGame() {
		this.player1 = 0;
		this.player2 = 0;
	}

	public String getScore() {
		String score;
		if (player1 == 3 && player2 == 3)
			score = "Deuce";
		else if (player1 == player2)
			score = scoreVals[player1] + " All";
		else
			score = scoreVals[player1] + " " + scoreVals[player2];
		return score;
	}
	
	public void player1Point() {
		if (player1 + 1 < scoreVals.length){
		   player1++;
		} 
		
	}

	public void player2Point() {
		if (player2 + 1 < scoreVals.length){
		  player2++;
		}
	}
}
