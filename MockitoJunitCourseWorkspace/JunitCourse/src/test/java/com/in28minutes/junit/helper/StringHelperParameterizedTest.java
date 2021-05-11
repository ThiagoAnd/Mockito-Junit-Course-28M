package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Nos usamos testes parametrizados quando temos varios testes que testam a mesma coisa só que com valores diferentes
//Exemplo: Testar se A é igual a B, se C é igual a J, etc. Podemos fazer com testes parametrizados para ficar com menos codigo
//duplicado.
//Esse exemplo é uma copia da classe StringHelper que fiz, mas com testes parametrizados
//A primeira coisa para dizer que esses testes irão ser testes parametrizados é colocar o parameterized.class no RunWith
//Segunda coisa, para esse teste criar variaveis que receberao os parametros e um construtor delas
//Terceira coisa, criar um metodo que sera os parametros e tem a annotation @Parameters

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	
	StringHelper helper = new StringHelper();
	
	private String input;
	private String expectedOutput;
	


	public StringHelperParameterizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	//Aqui colocamos as condições: Condição 1 e condição 2, o primeiro valor é o input, e o segundo output
	@Parameters
	public static Collection<String[]> testConditions() {
		String[][] expectedOutputs ={{"AACD","CD"},{"ACD","CD"}};
		
		return Arrays.asList(expectedOutputs);
	}
	
	//Esse teste vai rodar como se fosse 2 vezes, uma para cada conjunto de parametros
	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals(expectedOutput,helper.truncateAInFirst2Positions(input));
	}

	

		
}


