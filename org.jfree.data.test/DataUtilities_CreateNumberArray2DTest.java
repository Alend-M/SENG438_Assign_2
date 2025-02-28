package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.*;
import java.security.InvalidParameterException;
import java.util.Arrays;
import org.junit.Test;

//Author: Agustin

public class DataUtilities_CreateNumberArray2DTest{
	
	@BeforeClass
	public static void setUpClass() throws Exception {}
	
	@Before
	public void setUp() throws Exception {}
	
	Number [][] ExpectedArray2D = {{1.0,2.0,3.0},{4.0,5.0,6.0}};
	double [][] ParameterArray2D = {{1.0,2.0,3.0},{4.0,5.0,6.0}};
	double [][] emptyArray2D = {};
	double [][] ExceptionArray2D = null;
	

	//Tests if 2D array of doubles is coverted to a 2D array of numbers
	@Test 
	public void testCreateNumberArray2D()
	{
		assertArrayEquals("Array of Numbers",
				ExpectedArray2D, DataUtilities.createNumberArray2D(ParameterArray2D));
	}

	//Tests if empty 2D array is handled correctly
	@Test
    public void testEmptyArray2DConversion() {
		Number[][] result = DataUtilities.createNumberArray2D(emptyArray2D);
        assertEquals("Empty array should have length 0", 
                    0, result.length);
    }
	
	//Tests if IllegalArgumentException is thrown with a null argument
	@Test(expected = IllegalArgumentException.class)
	public void testCreateArrayException2D()
	{
		DataUtilities.createNumberArray2D(ExceptionArray2D);
	}
	
	
	
	@After
	public void tearDown() throws Exception{
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
	}
}
