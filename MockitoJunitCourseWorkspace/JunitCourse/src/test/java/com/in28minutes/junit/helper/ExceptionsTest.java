package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ExceptionsTest {

	@Test(expected = NullPointerException.class)
	public void test() {
		int[] numbers = null;

		Arrays.sort(numbers);

	}

}
