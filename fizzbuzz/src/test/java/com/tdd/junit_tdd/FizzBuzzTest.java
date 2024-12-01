package com.tdd.junit_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.tdd.junit_tdd.core.FizzBuzz;

public class FizzBuzzTest {
	@Test
	public final void testAvecValeurUn() {
		String res = FizzBuzz.fizzBuzz(1);
		assertEquals("1", res, "Problem with the number 1");
	}
	
	@Test
	public final void testAvecValeurDeux() {
		String res = FizzBuzz.fizzBuzz(2);
		assertEquals("2", res, "Problem with the number 1");
	}
	
	@Test
	public final void testAvecValeurTrois() {
		String res = FizzBuzz.fizzBuzz(3);
		assertEquals("Fizz", res, "Problem with the number 1");
	}
	
	@Test
	public final void testAvecValeurMultipleTrois() {
		for (int i = 3; i < 15; i *= 3) {
			String res = FizzBuzz.fizzBuzz(i);
			assertEquals("Fizz", res, "Problem with the number 1");
		}
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 1",
		"2, 2",
		"3, Fizz",
		"4, 4",
		"5, Buzz",
		"6, Fizz",
		"9, Fizz",
		"15, FizzBuzz"
	})
	public final void testFizzBuzz(int input, String expected) {
		String res = FizzBuzz.fizzBuzz(input);
		assertEquals(expected, res, "!!!");
	}
	
	@Test
	public final void  testAvecZero() {
		Throwable exception = assertThrows(Throwable.class, () -> {
			FizzBuzz.fizzBuzz(0);
		});
		assertEquals(IllegalArgumentException.class, exception.getClass());
	}
	
}
