package com.tdd.junit_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tdd.junit_tdd.core.BowlingGame;

public class BowlingGameTest {
	BowlingGame bowlingGame;
	
	@BeforeEach
	public void setupInstance() {
		bowlingGame = new BowlingGame();
	}
	
	public void iterate(int pins) {
		for (int roll_i = 0; roll_i < 20; roll_i ++) {
			bowlingGame.roll(pins);
		}
	}
	
	@Test
	public void scoreEqualsZero() {
		iterate(0);
		assertEquals(0, bowlingGame.score(), "Problem with frame [0, 0]");
	}
	
	@Test
	public void scoreEqualsTwenty() {
		iterate(1);
		assertEquals(20, bowlingGame.score(), "Problem with frame [1, 1]");
	}
	
	@Test
	public void spareInTheBeginning() {
		bowlingGame.roll(4);
		bowlingGame.roll(6);
		bowlingGame.roll(4);
		bowlingGame.roll(3);
		
		for (int roll_i = 0; roll_i < 16; roll_i ++) {
			bowlingGame.roll(0);
		}
		
		assertEquals(21, bowlingGame.score(), "Problem with spare in the beginning");
	}
	
	@Test
	public void spareInTheMiddle() {
		bowlingGame.roll(4);
		bowlingGame.roll(2);
		bowlingGame.roll(4);
		bowlingGame.roll(6);
		
		for (int roll_i = 0; roll_i < 16; roll_i ++) {
			bowlingGame.roll(1);
		}
		
		assertEquals(33, bowlingGame.score(), "Problem with spare in the middle");
	}
	
	@Test
	public void strikeInTheBeginning() {
		bowlingGame.roll(10);
		
		bowlingGame.roll(4);
		bowlingGame.roll(2);
		
		for (int roll_i = 0; roll_i < 16; roll_i ++) {
			bowlingGame.roll(0);
		}
		
		assertEquals(22, bowlingGame.score(), "Problem with strike in the beginning");
	}
	
	@Test
	public void strikeInTheMiddle() {
		bowlingGame.roll(4);
		bowlingGame.roll(2);
		
		bowlingGame.roll(10);
		
		for (int roll_i = 0; roll_i < 16; roll_i ++) {
			bowlingGame.roll(0);
		}
		
		assertEquals(16, bowlingGame.score(), "Problem with strike in the middle");
	}
    
}