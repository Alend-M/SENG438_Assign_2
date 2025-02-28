package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

//Author: Agustin

public class CalculateColTotalTest {
    private Mockery mocktext;
    private Values2D values;
    public static final double TOLERANCE = 0.000000001d;
    private Values2D negativeValues;

    // This is the setup method using the mock
    @Before
    public void setUp() throws Exception { 
        mocktext = new Mockery();

        //regularValues mock
        values = mocktext.mock(Values2D.class);
        
        mocktext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(4));
                one(values).getColumnCount();
                will(returnValue(4));
                
                allowing(values).getValue(0, 0); will(returnValue(5.0));
                allowing(values).getValue(0, 1); will(returnValue(-3.0));
                allowing(values).getValue(0, 2); will(returnValue(12.0));
                allowing(values).getValue(0, 3); will(returnValue(7.5));
                
                allowing(values).getValue(1, 0); will(returnValue(-7.0));
                allowing(values).getValue(1, 1); will(returnValue(8.5));
                allowing(values).getValue(1, 2); will(returnValue(0.0));
                allowing(values).getValue(1, 3); will(returnValue(3.0));
                
                allowing(values).getValue(2, 0); will(returnValue(10.0));
                allowing(values).getValue(2, 1); will(returnValue(4.0));
                allowing(values).getValue(2, 2); will(returnValue(-6.0));
                allowing(values).getValue(2, 3); will(returnValue(1.0));
                
                allowing(values).getValue(3, 0); will(returnValue(2.0));
                allowing(values).getValue(3, 1); will(returnValue(6.0));
                allowing(values).getValue(3, 2); will(returnValue(4.5));
                allowing(values).getValue(3, 3); will(returnValue(-2.0));
                
                allowing(values).getValue(with(any(Integer.class)), with(any(Integer.class)));
                will(returnValue(null));
            }
        });

        //negativeValues mock
        negativeValues = mocktext.mock(Values2D.class, "negativeValues");
        mocktext.checking(new Expectations() {
            {
                allowing(negativeValues).getRowCount();
                will(returnValue(4));
                allowing(negativeValues).getColumnCount();
                will(returnValue(4));
                allowing(negativeValues).getValue(0, -1);
                will(returnValue(null));
                allowing(negativeValues).getValue(1, -1);
                will(returnValue(null));
                allowing(negativeValues).getValue(2, -1);
                will(returnValue(null));
                allowing(negativeValues).getValue(3, -1);
                will(returnValue(null));
            }
        });
    }

    //Tests if the sum of values in the first column is correctly calculated
    @Test 
    public void calculateColumnTotal_firstColumnIndex() {
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("Sum of the first column", 10.0, result, TOLERANCE);
    }

    //Tests if the sum of values in the second column is correctly calculated
    @Test 
    public void calculateColumnTotal_middleColumnIndex() {
        double result = DataUtilities.calculateColumnTotal(values, 1);
        assertEquals("Sum of the middle column", 15.5, result, TOLERANCE);
    }

    //Tests if the sum of values in the third column is correctly calculated
    @Test 
    public void calculateColumnTotal_thirdColumnIndex() {
        double result = DataUtilities.calculateColumnTotal(values, 2);
        assertEquals("Sum of the third column", 10.5, result, TOLERANCE);
    }

    //Tests if the sum of values in the last column is correctly calculated
    @Test 
    public void calculateColumnTotal_lastColumnIndex() {
        double result = DataUtilities.calculateColumnTotal(values, 3);
        assertEquals("Sum of the last column", 9.5, result, TOLERANCE);
    }

    //Tests if the method handles out of bounds column index
    @Test 
    public void calculateColumnTotal_outOfBoundsColumnIndex() {
        double result = DataUtilities.calculateColumnTotal(values, 4);
        assertEquals("Sum of an out-of-bounds column", 0, result, TOLERANCE);
    }

    //Tests if method handles negative column index
    @Test
    public void calculateColumnTotal_negativeColumnIndex() {
        double result = DataUtilities.calculateColumnTotal(negativeValues, -1);
        assertEquals("Sum of a negative column index", 0.0, result, TOLERANCE);
    }

    //Tests if method throws IllegalArgumentException for a null argument
    @Test
    public void calculateColumnTotal_nullDataObject() {
    	try {
    		DataUtilities.calculateColumnTotal(null, 1);
    		fail("Expected IllegalArgumentException to be thrown");
    	}catch (IllegalArgumentException e) {
    		return;
    	} catch (Exception e) {
    		fail("Expected IllegalArgumentException, exception caught: " + e);
    	}
    }
}
