package brennan4114;

/**
 * 
 * @author dtbrennan1 - 020 194 114 
 * Assignment 2 - Part B 
 * JUnit testing of assignment 1's Simple Linked List and
 * JUnit testing of Assignment 2's Part C shapes.
 *     
 */

import org.junit.runner.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class runTest {
	public static void main(String[] args) {
		Result result1 = JUnitCore.runClasses(TestSimpleLinkedList.class);
		System.out.println("Part B Test Results: ");
		for (Failure failure : result1.getFailures())
			System.out.println(failure);
		if(result1.wasSuccessful())
			System.out.println("Tests finished successfully.");
	
		System.out.println();
		
		Result result2 = JUnitCore.runClasses(TestShapes.class);
		System.out.println("Part C Test Results: ");
		for (Failure failure : result2.getFailures())
			System.out.println(failure);
		if(result2.wasSuccessful())
			System.out.println("Tests finished successfully.");
	
	}
}
