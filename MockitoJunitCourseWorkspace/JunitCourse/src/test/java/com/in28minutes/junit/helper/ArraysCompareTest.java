package com.in28minutes.junit.helper;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	//Arrays.sort
	@Test
	public void testArraySort_RamdomArray() {
		int[] numbers = {12,3,4,1};
		int[] expected = {1,3,4,12};
		
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}

}
