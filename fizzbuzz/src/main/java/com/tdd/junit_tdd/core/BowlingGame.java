package com.tdd.junit_tdd.core;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	private int score;
	private List<Integer> rolls = new ArrayList<>();
    
    public void roll(int pins) {
        score += pins;
        rolls.add(pins);
    }

    public int score() {
    	
    	int rollIndex = 0;
    	while(rollIndex < rolls.size() - 2) {
			if (rolls.get(rollIndex) + rolls.get(rollIndex+1) == 10) {
				score += rolls.get(rollIndex+2);
				rollIndex += 2;
				continue;
			}
			
			if (rolls.get(rollIndex) == 10) {
    			score += rolls.get(rollIndex+1) + rolls.get(rollIndex+2);
    		}
			
			rollIndex++;
    	}
    	
        return score;
    }
}
