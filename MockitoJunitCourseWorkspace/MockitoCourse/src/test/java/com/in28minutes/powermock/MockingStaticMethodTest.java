package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


//Para começar a utilizar o powermock com um metodo estatico vc deve:
//	Ter as dependencias do powermock
//	Colocar essas duas anotações(RunWith powermockito e prepareForTest com o nome da classe que tem o metodo estatico)
//	mocar a classe com o powermockito

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	SystemUnderTest  systemUnderTest;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;


	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {

		
		List<Integer> stats = Arrays.asList(1,2,3);

		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		int result = systemUnderTest.methodCallingAStaticMethod();
		
		assertEquals(150,result);
		
		//O verify no powermock tambem é diferente
		//vc deve declarar em uma linha e chamar o metodo na segunda linha
		
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);

	}

	
}
