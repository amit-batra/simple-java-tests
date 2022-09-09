package com.batra.demo;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

public class JUnitTests {

	@Test
	public void validateNumberOfMethodCalls() {

		for (Integer integer: myListOfIntegers()) {
			System.out.printf("Integer: %s%n", integer);
		}
	}

	private List<Integer> myListOfIntegers() {
		final List<Integer> list = List.of(1, 2, 3, 4, 5);
		System.out.println("Method was invoked");
		return list;
	}
}