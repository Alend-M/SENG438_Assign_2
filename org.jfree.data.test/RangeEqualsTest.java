package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import java.util.*;

// Author: Agustin
// parameterized testing to reduce redundancy

@RunWith(Parameterized.class)
public class RangeEqualsTest{
	
	private Range range1;
	private Object range2;
	private boolean expected;
	
	public RangeEqualsTest(Range range1, Object range2, boolean expected)
	{
		this.range1 = range1;
		this.range2 = range2;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> parameters()
	{
		return Arrays.asList(new Object[][] {
			
			{ new Range(-1, 1), new Range(-1, 1), true }, // Identical ranges 
            { new Range(-1, 1), new Range(-0.5, 0.5), false }, // Different ranges
            { new Range(-1, 1), new Range(0, 1), false }, //Different start value
            { new Range(-1, 1), new Range(-50, 1), false }, // Range with larger different start values
            { new Range(-1, 1), new Range(-1, 5), false }, // Different end values
            { new Range(-1, 1), new Range(-1, 0), false }, // Range with larger different end values
            { new Range(-1, 1), new Range(50, 100), false }, // Different large ranges
            { new Range(-1, 1), new Range(-50, -5), false }, // Different large negative ranges
            { new Range(-1, 1), null, false },             // Null check
            { new Range(-1, 1), "Not a Range", false }     // Object of a different class
			
		});
	}

	//Test is parameterized to handle different test cases and avoid redundancies
	@Test
	public void testEquals() {
		assertEquals("Equals test failed for: " + range1 + " and " + range2,
				expected, range1.equals(range2));
	}
}
