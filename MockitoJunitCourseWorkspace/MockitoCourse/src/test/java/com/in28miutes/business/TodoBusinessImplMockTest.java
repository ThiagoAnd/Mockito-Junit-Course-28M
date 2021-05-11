package com.in28miutes.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;


public class TodoBusinessImplMockTest {

	//Um mock é muito dinamico, não é hard-coded
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
	
		
		TodoService todoServiceMock =  mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn the Spring","Learn to Danceee");
		
		//Quando eu ir no metodo retrieveTodos com a string DUMMY eu retorno essa lista acima
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//Como aqui eu utilizei a string DUMMY ela vai ativar o trigger para retornar aquela lista acima
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		for(String t: filteredTodos) {
			System.out.println(t);
		}
		assertEquals(2,filteredTodos.size());
	}

}
