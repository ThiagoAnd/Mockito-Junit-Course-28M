package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StringHelperTest {
	
	StringHelper helper ;
	
	@Before
	public void before() {
		helper = new StringHelper();
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
	}

	
	@Ignore
	@Test
	public void testd() {
		String actuald = helper.truncateAInFirst2Positions("AACD");
		String expected = "CD";
		assertEquals("ABC", "ABC");
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		
	}
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ab"));
		
	}
	
	
	
	
}


