package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Demo test unit
class TestDemoJUnitTest {
	private TestDemo testDemo;


	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
// Method test to assert that the two numbers are added correctly
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	 void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean exceptException) {
		
		if(!exceptException) {
			assertThat(TestDemo.addPositive(a, b)).isEqualTo(expected);
		
		}else {
			assertThatThrownBy(() -> TestDemo.addPositive(a,b))
			.isInstanceOf(IllegalArgumentException.class);
		}

	}
	// Testing that all the arguments are positive and added correctly, returning a stream of arguments
public static Stream <Arguments> argumentsForAddPositive(){
		//@formatter:off
		return Stream.of(
				arguments(5, 4, 6, true),
				arguments(-5, 8, 2, false),
				arguments(0, 0, 0, true),
				arguments(7, -9, -1, false),
				arguments(-6, -8, -2, true),
				arguments(10, 0, 3, false));
		//@formatter:on
		
	}
		
		@Test
		private void assertThatPairOfPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean exceptException) { 
			assertThat(TestDemo.addPositive(4, 5)).isEqualTo(9);
			assertThat(TestDemo.addPositive(40,50)).isEqualTo(90);
			assertThat(TestDemo.addPositive(35,-29)).isEqualTo(22);
			assertThat(TestDemo.addPositive(-5,7)).isEqualTo(2);
	}
		
	//Method to test if the number is squared correctly
		@Test
		@VisibleForTesting
		private void assertThatNumberSquaredIsCorrect() {
			TestDemo mockDemo = new TestDemo();
			mockDemo = spy(mockDemo);
			doReturn(5).when(mockDemo).getRandomInt();
			int fiveSquared = mockDemo.randomNumberSquared();
			assertThat(fiveSquared).isEqualTo(25);
		}
	
	
}
