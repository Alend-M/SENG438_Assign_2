package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range; 
import org.junit.*;

/**
 * This class contains unit tests for testing the toString() method of the Range class.
 * It verifies that the string representation of Range objects is correctly formatted 
 * as "Range[lower,upper]" for various scenarios.
 * 
 * Test cases include:
 * - Range with negative lower bound and positive upper bound
 * - Range with both negative lower and upper bounds
 * - Range with both positive lower and upper bounds
 * - Range where lower bound equals upper bound (zero-length range)
 * 
 * @see Range
 * @see org.junit.Test
 * @see org.junit.Before
 */
public class RangeToStringTest {
	    private Range range1;
	    private Range range2;
	    private Range range3;
	    private Range range4;

    @Before
    public void setUp() { 
    	range1 = new Range(-100.0, 100.0);
    	range2 = new Range(-5.5, -2.0);
    	range3 = new Range(10.0, 100.0);
    	range4 = new Range(-20.0, -20.0);
 
    }

   
    // Test the toString() method with a Range object containing both negative and positive values.
    @Test
    public void toString_negative_and_positive() {
        assertEquals("Expecting string \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
        "Range[-100.0,100.0]", range1.toString());
    }

    // Test the toString() method with a Range object containing both negative values.
    @Test
    public void toString_negative_and_negative() {
    	assertEquals("Expecting string \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"Range[-0.5,0.0]", range2.toString());
    }

    // Test the toString() method with a Range object containing both positive values.
    @Test
    public void toString_positive_and_positive() {
    	assertEquals("Expecting string \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"Range[10.0,100.0]", range3.toString());
    }

    // Test the toString() method with a Range object where the lower bound equals the upper bound.
    @Test
    public void toString_no_difference() {
    	assertEquals("Expecting string \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"Range[-20.0,-20.0]", range4.toString());
    }
}
