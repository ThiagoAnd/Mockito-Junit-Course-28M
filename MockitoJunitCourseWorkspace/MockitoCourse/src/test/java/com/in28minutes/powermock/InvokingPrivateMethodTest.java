package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

//Aqui vamos mocar um construtor, o que tambem não é desejavel mas vamos mostrar
//Mesmo que vamos mexer com o construtor do arrayList, ele esta dentro do SystemUnderTest.class
//então devemos colocar ela no preparefor test e não o array list.class

//Ele não mostrou o codigo rodando se eu vi bem, ele esta dando uma runtime exception
//Mas como é uma pratica ruim de fazer teste com construtor, metodos privados e estatico não vou me atentar a resolver
@PrepareForTest(SystemUnderTest.class)
@RunWith(PowerMockRunner.class)
public class InvokingPrivateMethodTest {

	@Mock

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Mock
	ArrayList mockList;

	@Test
	public void testBadNames() throws Exception {

		List<Integer> stats = Arrays.asList(1, 2, 3);
		
		when(mockList.size()).thenReturn(5);
		
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		
		assertEquals(5,size);

	}

}
