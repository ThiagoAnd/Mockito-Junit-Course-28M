package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class StringHelperTest {

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		StringHelper helper = new StringHelper();
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
	}

	
	@Ignore
	@Test
	public void testd() {
		StringHelper helper = new StringHelper();
		String actuald = helper.truncateAInFirst2Positions("AACD");
		String expected = "CD";
		assertEquals("ABC", "ABC");
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		StringHelper helper = new StringHelper();
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
	}
	
	
}


