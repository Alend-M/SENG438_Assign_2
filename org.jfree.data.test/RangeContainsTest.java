package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeContainsTest {

    private Range range; 

    //Setting up the range object with a range of -200 to 200
    @Before
    public void setUp() throws Exception { 
        range = new Range(-200, 200);
    }
    
    //Test if the range contains a positive number within the range
    @Test
    public void contains_positive_in_range() {
        boolean result = range.contains(100);
    	assertEquals("Range contains 100:",  true, result);
    }

    //Test if the range contains a negative number within the range
    @Test
    public void contains_negative_in_range() {
        boolean result = range.contains(-100);
    	assertEquals("Range contains -100:",  true, result);
    }

    // Test if the range contains the start of the range
	@Test 
    public void contains_start_range() {
        boolean result = range.contains(-200);
    	assertEquals("Range contains -200:",  true, result);
    }
    
    // Test if the range contains the end of the range
    @Test
    public void contains_end_range() {
        boolean result = range.contains(200);
    	assertEquals("Range contains 200:",  true, result);
    }

    // Test if the range contains a positive number outside the range
    @Test
    public void contains_positive_outside_range() {
        boolean result = range.contains(201);
        assertEquals("Range contains 201:",  false, result);
    }

    // Test if the range contains a negative number outside the range
    @Test
    public void contains_negative_outside_range() {
        boolean result = range.contains(-201);
    	assertEquals("Range contains -201:",  false, result);
    }

    // Test if the range contains a number that is not an integer
    @Test
    public void contains_decimal_in_range() {
    	boolean result = range.contains(10.56);
    	assertEquals("Range contains 10.56:",  true, result);
    }
    
    // Test if the range contains a number that is not an integer
    @Test
    public void contains_decimal_outside_range() {
    	boolean result = range.contains(200.1);
    	assertEquals("Range contains 200.1:",  false, result);
    }
}
    