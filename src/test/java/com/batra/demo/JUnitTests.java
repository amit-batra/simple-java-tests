package com.batra.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class JUnitTests {

	private static final List<Integer> LIST_OF_INTEGERS = List.of(1, 2, 3, 4, 5);
	private long invocationCount_myListOfIntegers;

	@BeforeEach
	public void initializeGlobals() {
		invocationCount_myListOfIntegers = 0L;
	}
	@Test
	public void validateNumberOfMethodCalls() {

		for (Integer integer: myListOfIntegers()) {
			System.out.printf("Integer: %s%n", integer);
		}

		assertTrue(invocationCount_myListOfIntegers == 1);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 7, 9})
	public void validateNumberIsOdd(int n) {
		assertTrue(n % 2 == 1);
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 4, 6, 8, 10})
	public void validateNumberIsEven(int n) {
		assertTrue(n % 2 == 0);
	}

	private List<Integer> myListOfIntegers() {
		System.out.printf("Method myListOfIntegers is invoked. Invocation count = %d%n", ++invocationCount_myListOfIntegers);
		return LIST_OF_INTEGERS;
	}

	@ParameterizedTest
	@ValueSource(strings = {"JUL", "SEP", "DEC"})
	public void testValidMonths(final String name) {
		assertDoesNotThrow(() -> Month.valueOf(name));
	}

	@ParameterizedTest
	@ValueSource(strings = {"ABC", "XYZ", "PQR"})
	public void testInvalidMonths(final String name) {
		assertThrows(IllegalArgumentException.class, () -> Month.valueOf(name));
	}

	@ParameterizedTest
	@EnumSource(value = Month.class, names = {"JAN", "FEB", "MAR"})
	public void validateMonthLength(final Month month) {
		assertTrue(month.toString().length() == 3);
	}

	public enum Month {
		JAN,
		FEB,
		MAR,
		APR,
		MAY,
		JUN,
		JUL,
		AUG,
		SEP,
		OCT,
		NOV,
		DEC
	}
}