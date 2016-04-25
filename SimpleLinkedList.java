package brennan4114;

/**
 * 
 * @author dtbrennan1 - 020 194 114 
 * Assignment 1 - Part A 
 * Implementation of linked list
 *     
 */
public class SimpleLinkedList {
	public Node head; // Head is first node in linked list

	public SimpleLinkedList() { }

	public SimpleLinkedList(Node head) { }

	// Boolean to see if linked list is
	// empty, returning true if so.
	public boolean isEmpty() {
		return length() == 0;
	}

	// Takes individual values of Student# as String 
	// data and assigns them into the end of list.
	// With validation for inserting the first data
	// into the first index of list.
	public void insertAtEnd(String data) {
		if (isEmpty()) {
			insertAtBeginning(data);
		}

		Node sslTemp = new Node(data);
		Node sslCurrent = head;

		if (sslCurrent != null) {
			while (sslCurrent.getNext() != null) {
				sslCurrent = sslCurrent.getNext();
			}
			sslCurrent.setNext(sslTemp);
		}
	}

	// First value being inserted into list
	// by inserting the data received.
	public void insertAtBeginning(String data) {
		Node sllTemp = new Node(head, data);
		head = sllTemp;
	}

	// Finds the data value at the end of list
	// and returns that value
	public Node tail() {
		Node tail = head;
		while (tail.getNext() != null)
			tail = tail.getNext();
		return tail;
	}

	// Counts iterations when inserting into List
	// begins at 1 and moves forward with
	// some simple validation to ensure accuracy
	public int length() {
		int count = 0;
		Node sllCurrent = this.head;
		while (sllCurrent != null) {
			if (sllCurrent.next != null)
				count++;
			sllCurrent = sllCurrent.getNext();
		}
		return count;
	}

	// Inserts at index replacing the original
	// data with new data being received as a String
	void insertAtIndex(int idx, String data) {
		Node insertNew = findAtIndex(idx);
		insertNew.data = data;
	}

	// Finds the data value at an implicit 
	// integer index and returns specific value
	Node findAtIndex(int idx) {
		if (idx <= 0) {
			return head;
		}
		Node sslCurrent = head;
		for (int i = 0; i < idx; i++) {
			sslCurrent = sslCurrent.getNext();
		}
		return sslCurrent;
	}

	// Finds value at implicit index
	// and replaces value with a ""
	void deleteAtIndex(int idx) {
		Node deleteNode = findAtIndex(idx);
		deleteNode.data = "";
	}

	// Implicit function to create accurate output
	@Override
	public String toString() {
		String o = "";
		if (head != null) {
			Node sslCurrent = head.getNext();
			while (sslCurrent != null) {
				o += sslCurrent.getData().toString();
				sslCurrent = sslCurrent.getNext();
			}
		}
		return o;
	}

	/* this methods reverse the list, for example 30891147 becomes 74119803 */
	Node reverse() {
		Node prev = null;
		Node curr = head.next;
		Node temp = null;
		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	/* the same as previous method but use the recursive style */
	void reverseRecursive(Node p) {
		if (p == null) {
			return;
		}
		if (p.next == null) {
			head = p;
			return;
		}
		reverseRecursive(p.next);
		p.next.next = p;
		p.next = null;
	}

	// Deletes first instance of implicit data
	// also can delete all instances of implicit
	// data with the removal of break;
	void deleteData(String s) {
		Node node = head;
		while (node.getNext() != null) {
			if (node.data.equals(s)) {
				node.data = "";
				break; // To remove all instances of String s remove break;
			} else {
				node = node.getNext();
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleLinkedList other = (SimpleLinkedList) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}

	// Node is nested class because it only exists along with linked list
	public static class Node {
		private String data;
		private Node next;

		// Constructor
		public Node(String _data) {
			next = null;
			data = _data;
		}

		// Overload Constructor
		public Node(Node _next, String _data) {
			next = _next;
			data = _data;
		}

		// Setter for Node next
		public void setNext(Node _next) {
			next = _next;
		}

		// Getter for Node next
		public Node getNext() {
			return next;
		}

		// Setter for String data
		public void setData(String _data) {
			data = _data;
		}

		// Getter for String data
		public String getData() {
			return data;
		}

		// toString for Node next
		@Override
		public String toString() {
			return "" + data;
		}

		// heashCode for Node next
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			return result;
		}

		// equals for Node next
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			return true;
		}

	}

	// Build from list takes a long data value and
	// breaks each number into an individual instance 
	// that is then inserted into the linked list.
	public void buildListFromID(long num, SimpleLinkedList digits) {
		if (num / 10 > 0) {
			buildListFromID(num / 10, digits);
		}
		String s = String.valueOf(num % 10);
		digits.insertAtEnd(s);
	}

	// Main with a call to default functions
	public static void main(String[] args) {
		SimpleLinkedList sll = new SimpleLinkedList();
		long sid = 120194114L;
		sll.buildListFromID(sid, sll);
		System.out.println(sll); // *
		
		for (int i = 1; i <= sll.length(); i++) 
			System.out.print(sll.findAtIndex(i)); // **		
		// your program must print twice from * and **
		// your student ID
		// 120194114
		// 120194114
	}
}