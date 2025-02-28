package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class CalculateRowTotalTest {
    private Mockery mocktext;
    private Values2D values;
    public static final double TOLERANCE = 0.000000001d;
    
    // This is the setup method using the mockery library
    @Before
    public void setUp() throws Exception { 
        mocktext = new Mockery();
        values = mocktext.mock(Values2D.class);
        mocktext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(4));
                one(values).getColumnCount();
                will(returnValue(4));
                
                // populate first row index
                allowing(values).getValue(0, 0); will(returnValue(4.0));
                allowing(values).getValue(0, 1); will(returnValue(7.0));
                allowing(values).getValue(0, 2); will(returnValue(-2.0));
                allowing(values).getValue(0, 3); will(returnValue(5.5));
                
                // populate second row index
                allowing(values).getValue(1, 0); will(returnValue(-3.0));
                allowing(values).getValue(1, 1); will(returnValue(2.5));
                allowing(values).getValue(1, 2); will(returnValue(0.0));
                allowing(values).getValue(1, 3); will(returnValue(13.0));
                
                // populate third row index
                allowing(values).getValue(2, 0); will(returnValue(1.5));
                allowing(values).getValue(2, 1); will(returnValue(4.0));
                allowing(values).getValue(2, 2); will(returnValue(-9.5));
                allowing(values).getValue(2, 3); will(returnValue(10.0));
                
                // populate fourth row index
                allowing(values).getValue(3, 0); will(returnValue(19.0));
                allowing(values).getValue(3, 1); will(returnValue(6.5));
                allowing(values).getValue(3, 2); will(returnValue(4.0));
                allowing(values).getValue(3, 3); will(returnValue(-12.0));
                
                // populate negative row index
		        one(values).getValue(-1, 0); will(returnValue(1.0));
		        one(values).getValue(-1, 1); will(returnValue(12.0));
		        one(values).getValue(-1, 2); will(returnValue(-3.0));
		        one(values).getValue(-1, 3); will(returnValue(0.0));
		        
		        // populate out of bounds row index
	            one(values).getValue(4, 0); will(returnValue(-3.5));
	            one(values).getValue(4, 1); will(returnValue(2.5));
	            one(values).getValue(4, 2); will(returnValue(13.0));
				one(values).getValue(4, 3); will(returnValue(-7.0));
            }
        });
    }
    
    // Test method testing the sum of the first row
    @Test 
    public void calculateRowTotal_firstRowIndex() {
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("Sum of the first row", 14.5, result, TOLERANCE);
    }
    
    // Test method testing the sum of the second row
    @Test 
    public void calculateRowTotal_SecondRowIndex() {
        double result = DataUtilities.calculateRowTotal(values, 1);
        assertEquals("Sum of the second row", 13.5, result, TOLERANCE);
    }
    
    // Test method testing the sum of the third row
    @Test 
    public void calculateRowTotal_thirdRowIndex() {
        double result = DataUtilities.calculateRowTotal(values, 2);
        assertEquals("Sum of the third row", 6.0, result, TOLERANCE);
    }
    
    // Test method testing the sum of the fourth row
    @Test 
    public void calculateRowTotal_fourthRowIndex() {
        double result = DataUtilities.calculateRowTotal(values, 3);
        assertEquals("Sum of the fourth row", 17.5, result, TOLERANCE);
    }
    
    // Test method testing the sum a row that is out of bounds
    @Test 
    public void calculateRowTotal_outOfBoundsRowIndex() {
        double result = DataUtilities.calculateRowTotal(values, 4);
        assertEquals("Sum of an out of bounds row", 0, result, TOLERANCE);
    }
    
    // Test method testing the sum of a negative row index
    @Test
    public void calculateRowTotal_negativeRowIndex() {        
        double result = DataUtilities.calculateRowTotal(values, -1);
        assertEquals("Sum of a negative row index", 0.0, result, TOLERANCE);
    }
    
    // Test method testing the sum of a row index that is null
    @Test
    public void calculateRowTotal_nullDataObject() {
    	try {
            DataUtilities.calculateRowTotal(null, 1);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            return;
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, exception caught: " + e);
        }
    }
}
