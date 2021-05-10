package com.in28minutes.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {
	
	//Executado uma vez na classe
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class method");
	}
	
	//Executado todas as vezes antes de cada teste
	@Before
	public void setup() {
		System.out.println("Before test");
	}

	@Test
	public void test1() {
		System.out.println("Test1 executed");
	}
	@Test
	public void test2() {
		System.out.println("Test2 executed");
	}
	
	@After
	public void tearDown() {
		System.out.println("After test");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class method");
	}

}
