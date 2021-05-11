package com.in28miutes.business;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	//Esse teste faz o mock da classe List e e atribui para uma variavel, e quando chamo o .size vai dar sempre 2
	@Test
	public void testMockListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		
		assertEquals(2,listMock.size());
	}
	
	//Aqui é utilizado o encadeamento de metodos para retornar varios valores a cada chamada
	@Test
	public void testMockListSizeMethod_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(5);
		
		assertEquals(2,listMock.size());
		assertEquals(5,listMock.size());
	}
	
	@Test
	public void testMockListGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("Thiago");
		
		assertEquals("Thiago",listMock.get(0));
	
	}

	//Aqui utilizamos o anyInt do mockito matchers para que qualquer numero escolhido seja valido
	@Test
	public void testMockListGetAnyInt() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("Thiago");
		
		assertEquals("Thiago",listMock.get(5));
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testMockList_throwAnException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Alguma coisa"));
		
		listMock.get(5);
		
	}
}
