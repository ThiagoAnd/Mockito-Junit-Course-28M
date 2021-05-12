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
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {

	@Mock
	TodoService todoServiceMock;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {

		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn the Spring", "Learn to Danceee");

		// Quando eu ir no metodo retrieveTodos com a string DUMMY eu retorno essa lista
		// acima
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// Como aqui eu utilizei a string DUMMY ela vai ativar o trigger para retornar
		// aquela lista acima
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

		// Podemos usar o given e o willReturn no lugar do when e thenReturn quando
		// vamos usar o padrão do BDD
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When - Specific action

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Then
		// O assertThat pode ser usado no lugar do assertEquals , dependendo pode deixar
		// o codigo mais claro
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {

		// Given - Setup

		

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn the Spring", "Learn to Danceee");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When - Specific action

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then
		// Nós sabemos que a unica string que não esta relacionada com Spring é a ultima
		// (learn to Danceee)
		// Então aqui temos que colocar a logica para verificar se o metodo foi chamado
		// para ela, é aqui que o verify entra em ação

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

		// Declaring the argument captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		

		// Given - Setup

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn the Spring", "Learn to Danceee");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When - Specific action

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then

		// Verifica se o metodo deleteTodo foi chamado para a string learn to dancee
		verify(todoServiceMock).deleteTodo(stringArgumentCaptor.capture());
		
		
		//Aqui é verificado se na chamada do metodo deleteTodo o parametro passado foi Learn to Danceee
		assertThat(stringArgumentCaptor.getValue(),is("Learn to Danceee"));

	}
}
