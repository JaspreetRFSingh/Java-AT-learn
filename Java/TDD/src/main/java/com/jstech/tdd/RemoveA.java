package com.jstech.tdd;

public class RemoveA {

	public String removeA(String input) {
		int size = input.length();
		String result = "";
		for(int charIndex = 0; charIndex < 2 && charIndex<size; charIndex ++) {
			if(input.charAt(charIndex) != 'A') {
				result += input.charAt(charIndex);
			}
		}
		if(size>2) {
			for(int charIndex = 2; charIndex <size; charIndex++) {
				result+=input.charAt(charIndex);
			}
		}
		
		return result;
	}


}
