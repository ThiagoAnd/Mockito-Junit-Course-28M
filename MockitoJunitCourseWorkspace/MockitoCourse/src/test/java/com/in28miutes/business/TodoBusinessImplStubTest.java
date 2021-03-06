package com.in28miutes.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	
	@Test
	public void testRetrieveTodosRelatedToSpring() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		
	
		assertEquals(2,filteredTodos.size());
	}

}
