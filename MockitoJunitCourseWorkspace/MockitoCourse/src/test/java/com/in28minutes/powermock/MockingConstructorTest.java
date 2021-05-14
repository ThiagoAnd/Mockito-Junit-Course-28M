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
import org.powermock.reflect.Whitebox;


//Como usar o powermock para invocar metodo privado, o que não é uma das melhores praticas, mas somente para mostrar

@RunWith(PowerMockRunner.class)
public class MockingConstructorTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	SystemUnderTest  systemUnderTest;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;


	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() throws Exception {

		
		List<Integer> stats = Arrays.asList(1,2,3);

		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		//Whitebox é usado para chamar metodos privados
		long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		
		assertEquals(6,result);

	}

	
}
