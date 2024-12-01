package com.tdd.junit_tdd.core;

public class FizzBuzz {
	public static String fizzBuzz(int x) {
		if (x == 0) throw new IllegalArgumentException();
		if (x % 3 == 0 && x % 5 == 0) return "FizzBuzz";
		if (x % 3 == 0) return "Fizz";
		if (x % 5 == 0) return "Buzz";
		return Integer.toString(x);
	}
}
