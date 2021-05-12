package com.in28miutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {

	@Mock
	TodoService todoServiceMock;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	// Seria como se tivesse feito o seguinte:
	// TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	// o InjectMocks cria uma instancia de uma classe e injeta os mocks que foram criados com o @mock

//	@Mock creates a mock. @InjectMocks creates an instance of the class and injects 
//	the mocks that are created with the @Mock (or @Spy) annotations into this instance.
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	//Seria mais ou menos igual ao que foi implementado sem a anotação:
	//ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {

		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn the Spring", "Learn to Danceee");

		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		for (String t : filteredTodos) {
			System.out.println(t);
		}
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {

		// Given - Setup

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn the Spring", "Learn to Danceee");

		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When - Specific action

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Then
	
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {

		// Given - Setup

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn the Spring", "Learn to Danceee");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);


		// When - Specific action

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then
		
		// Verifica se o metodo deleteTodo foi chamado para a string learn to dancee
		verify(todoServiceMock).deleteTodo("Learn to Danceee");

		// Verifica se o metodo nunca foi chamado para a string learn the spring
		verify(todoServiceMock, never()).deleteTodo("Learn the Spring");

		// Verificar se o metodo foi chamado 1 ou mais vezes
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Danceee");

		// Verificar se o metodo foi chamado pelo menos uma vez
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Danceee");

		// Verificar se o metodo foi chamado pelo menos uma ou mais vezes
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Danceee");

	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_withArgumentCapture() {

	
		// Given - Setup

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn the Spring", "Learn to Danceee");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);


		// When - Specific action

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then

		// Verifica se o metodo deleteTodo foi chamado para a string learn to dancee
		verify(todoServiceMock).deleteTodo(stringArgumentCaptor.capture());

		// Aqui é verificado se na chamada do metodo deleteTodo o parametro passado foi
		// Learn to Danceee
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Danceee"));

	}
}
