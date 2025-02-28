package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;
import java.security.InvalidParameterException;

public class createNumberArrayTest {

	// Test with valid inputs
	@Test
	public void testCreateNumberArrayWithValidInput() {
		double[] input = {1.1, 10.1, 2.2};
		Number[] expectedOutput = {1.1, 10.1, 2.2};
		Number[] actualOutput = DataUtilities.createNumberArray(input);
		
		assertArrayEquals("Method should convert double primitive array to a Number array", expectedOutput, actualOutput);
 	}
	
	// Test with empty array
	@Test
	public void testCreateArrayWithEmptyArray() {
		double[] input = {};
		Number[] expectedOutput = {};
		Number[] actualOutput = DataUtilities.createNumberArray(input);
		
		assertArrayEquals("Method should handle the conversion of an empty double array", expectedOutput, actualOutput);
 	}
	
	// Test with null input
	@Test 
	public void testCreateArrayWithNull() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("Expected IllegalArgumentException to be thrown");
		}
		catch (IllegalArgumentException e) {
			return;
		}
		catch (Exception e){
			fail("Expected IllegalArguemntException to be thrown");
		}
	}
	
	// Test with large array
	@Test
	public void testCreateNumberArrayLargeArray() {
	    double[] input = new double[1000000];
	    for (int i = 0; i < input.length; i++) {
	        input[i] = i * 1.1;
	    }
	    Number[] result = DataUtilities.createNumberArray(input);
	    assertEquals(input.length, result.length);
	}
	
	// Test with negative numbers
	@Test
	public void testCreateNumberArrayNegativeNumbers() {
	    double[] input = {-1.5, -2.75, -3.0};
	    Number[] expected = {-1.5, -2.75, -3.0};
	    Number[] result = DataUtilities.createNumberArray(input);
	    assertArrayEquals(expected, result);
	}
}
