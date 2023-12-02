package com.promineotech;

import java.util.Random;
	
// A demo Junit Test Class
public class TestDemo {
	
	//Method takes two int parameters, determines if they are both positive, if they are returns the sum of the two
	public static int addPositive(int a, int b) {
		
		if (a > 0 && b>0) {
			return a + b;
		}else {
			throw new IllegalArgumentException("Both parameters must be postive");
		
		}
		}
	
	//Method that acquires a random number, square it, and return the results
	public int randomNumberSquared() {
		int tempInt= getRandomInt();
		return tempInt*tempInt;
	}
	
	// Method that acquires a random int in the range of 1 - 10
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	}