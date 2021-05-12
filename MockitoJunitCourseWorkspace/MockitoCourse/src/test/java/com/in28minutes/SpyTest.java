package com.in28minutes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


public class SpyTest {
	
	

	@Test
	public void testSemSpy() {
		ArrayList arrayListMock = mock(ArrayList.class);
		assertEquals(0, arrayListMock.size());
		
		//Mock return default value
		stub(arrayListMock.size()).toReturn(5);
		
		assertEquals(5, arrayListMock.size());
	}

	//O mock não permite vc alterar nenhum valor, mesmo se vc tirar o stub ele não permite vc alterar o valor
	//Ja com o spy vc tem a opção de manipular o valor de alguma coisa do que foi mockado, vc pode manipular apenas algum
	//metodo e deixar o resto como default
	@Test
	public void testComSpy() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		assertEquals(0, arrayListSpy.size());

		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
	}
}
