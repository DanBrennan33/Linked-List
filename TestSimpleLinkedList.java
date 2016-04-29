package brennan4114;

/**
 * 
 * @author dtbrennan1 - 020 194 114 
 * Assignment 2 - Part B 
 * JUnit testing of assignment 1's Simple Linked List
 *     
 */

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *  Class for testing cases
 */
public class TestSimpleLinkedList {
	SimpleLinkedList s = new SimpleLinkedList();
	
	/**
	 *  Build SimpleLinkedList for test cases
	 */
	public TestSimpleLinkedList() {
		long sid = 120194114L;
		s.buildListFromID(sid, s);
	}
	
	/**
	 *  Test case for DeleteAtIndex method
	 */
	@Test
	public void testDeleteAtIndex() {
		s.deleteAtIndex(2);
		assertEquals("Test for DeleteAtIndex(2): ", "10194114", s.toString());
	}

	/**
	 *  Test case for DeleteData method
	 */
	@Test
	public void testDeleteData() {
		s.deleteData("4");
		assertEquals("Test for deleteData(\"4\"): ", "12019114", s.toString());
	}
	
	/**
	 *  Test case for Equals method
	 */
	@Test
	public void testEquals() {
		boolean t = true;
		t = (s.toString()).equals("120194114");
		assertEquals("Test for equals(120194114): ", true, t);
	}
	
	/**
	 *  Test case for findAtIndex method
	 */
	@Test
	public void testfindAtIndex() {
		assertEquals("Test for findAtIndex(4): ", "1", s.findAtIndex(4).toString());
	}
	
	/**
	 *  Test case for HashCode method
	 */
	@Test
	public void testHashCode() {
		assertEquals("Test for hashCode(): ", 111, s.hashCode());
	}
	
	/**
	 *  Test case for InsertAtBeginning method
	 */
	@Test
	public void testInsertAtBeginning() {
		s.insertAtBeginning("5");
		assertEquals("Test for InsertAtBeginning(\"5\"): ", "5120194114", s.toString());
	}
	
	/**
	 *  Test case for InsertAtEnd method
	 */
	@Test
	public void testInsertAtEnd() {
		s.insertAtEnd("6");
		assertEquals("Test for InsertAtEnd(\"6\"): ", "1201941146", s.toString());
	}
	
	/**
	 *  Test case for InsertAtIndex method
	 */
	@Test
	public void testInsertAtIndex() {
		s.insertAtIndex(4, "8");
		assertEquals("Test for InsertAtIndex(4, \"8\"): ", "120894114", s.toString());
	}
	
	/**
	 *  Test case for isEmpty method
	 */
	@Test
	public void testisEmpty() {
		boolean t = true;
		t = s.isEmpty();
		assertEquals("Test for isEmpty(): ", false, t);
	}
	
	/**
	 *  Test case for Length method
	 */
	@Test
	public void testLength() {
		assertEquals("Test for length(): ", 9, s.length());
	}
	
	/**
	 *  Test case for Reverse method
	 */
	@Test
	public void testReverse() {
		s.reverse();
		assertEquals("Test for reverse(): ", "41149021", s.toString());
	}
	
	/**
	 *  Test case for ReverseRecursive method
	 */
	@Test
	public void testReverseRecursive() {
		s.reverseRecursive(s.head);
		assertEquals("Test for reverseRecursive(): ", "41149021", s.toString());
	}
	
	/**
	 *  Test case for Tail method
	 */
	@Test
	public void testTail() {
		assertEquals("Test for reverseRecursive(): ", "4", s.tail().toString());
	}
}
