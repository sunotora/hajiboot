package com.example.app;

import org.springframework.stereotype.Component;

//2.1.1
@Component
public class AddCalculator implements Calculator {
	@Override
	public int calc(int a, int b) {
		return a + b;
	}

}
