package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PerformanceTests {

	//Aqui podemos testar se o nosso metodo de teste esta executando dado um tempo em milissegundos
	//Timeout im miliseconds
	@Test(timeout=1000)
	public void testSort_Performance() {
		int[] array = {12,23,4};
		for(int i=1;i<=1000000;i++) {
			array[0] = i;
			Arrays.sort(array);
		}
	}

}
