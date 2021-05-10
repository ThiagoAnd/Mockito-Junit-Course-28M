package com.in28minutes.junit.helper;

public class StringHelper {

	//Se receber AACD retorna CD
	//Se receber ACD  retorna CD
	//Se receber CDEF retorna CDEF
	//Se receber CDAA retorna CDAA
	public String truncateAInFirst2Positions(String str) {
		if (str.length() <= 2)
			return str.replaceAll("A", "");

		String first2Chars = str.substring(0, 2);
		String stringMinusFirst2Chars = str.substring(2);

		return first2Chars.replaceAll("A", "") 
				+ stringMinusFirst2Chars;
	}

	//ABCD retorna false
	//ABAB retorna true
	//AB retorna true pois AB pode ser o primeiro e o segundo, mas tambem pode ser o penultimo e ultimo
	//A retorna false pois não existe o segundo character
	public boolean areFirstAndLastTwoCharactersTheSame(String str) {

		if (str.length() <= 1)
			return false;
		if (str.length() == 2)
			return true;

		String first2Chars = str.substring(0, 2);

		String last2Chars = str.substring(str.length() - 2);

		return first2Chars.equals(last2Chars);
	}

}