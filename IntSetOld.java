/*
 * This class maintains a set of ints. 
 */
import java.util.*;
public class IntSet {
	private Node set;		// An array to represernt the set. This is always maintained in sorted order.
	private int capacity;	// The maximum allocated memory for the set.
	private int size;		// The number of elements currently stored in the set.
	
	public IntSet() {
		size = 0;
		capacity = 10;
		set = null;
		//instead of an array, we will need to build a linked list 
		//with the head pointing to the new linked list made from 
		//from the array passed in.
		//head = new Node((int) set, head); 
	}
	/* -------------------------------------------------
	 * Placing this here in case IntSet doesn't find it
	 * in the directory. 
	 * -------------------------------------------------
	 
	public class Node {
		public int digit;
		public Node next;
	
		public Node (int d, Node n) {
			digit = d;
			next = n;
		}
	}  
	*/
	static Node insertNode(Node head, int data) {
		Node cur = new Node(data, head);
		Node ptr;
		cur.digit = data; 
		cur.next = null;

		if (head == null) 
			head = cur;
		else {
			ptr = head;
			while (ptr.next != null)
				ptr = ptr.next;
			ptr.next = cur;
		}
		return head;
	}

	public static Node arrToList(int[] set, int capacity) {
		Node head = null;
		for (int i = 0; i < capacity; ++i)
			head = insertNode(head, set[i]);
		return head;
	}
	
	/* Find if a key is present in the set. Returns true if the key is present, otehrwise false.*/
	public boolean find(int key) {
		// binary search
		int low = 0, high = size-1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (set[mid] == key) return true;
			if (key > set[mid]) low = mid + 1;
			else high = mid - 1;
		}
		return false;
	}
	
	/* Insert a key into the set. */
	public void insert(int key) {
		// Make sure that the key is not present.
		assert (!find(key));
		// Since we are using linked-list, size is
		// not crucial. We only need to watch for 
		// the end of the list (null).@interface
		/* 
		// Reached capacity? Then expand.
		if (size == capacity) {
			int [] oldset = set;
			set = new int [2 * capacity];
			for (int i = 0; i < capacity; i++)
				set[i] = oldset[i];
			capacity = 2 * capacity;
		}
		*/
		// Perform insert.
		// Insert in sorted order.
		int i;
		if ( set == null)
			set = new Node( key, null);
		while (set != null) {
			// Iterate through the list looking for "key"
			// There should be 3 cases k<, <k>, and k>
			// First check for if the key is less than the
			// first digit in the list.
			if (key < set.digit) {
				// Move head in front of key and point
				// next to the previous head.
				set.digit = key;
				set = set.next;
			} else {
				set.digit = key;
				set = set.next;
			}
		}
		/* 
		for (i = size - 1; i >= 0 && set[i] > key; i--)
			set[i+1] = set[i];
		set[i+1] = key;
		size++;
		*/
	}
	
	/* Remove a key from the set. */
	public void remove(int key) {
		// Make sure that the key is present.
		assert (find(key));
		
		// Find the position of the key.
		int pos;
		for (pos = 0; pos < size && set[pos] != key; pos++);
		
		// Perform remove.
		for (; pos < size; pos++)
			set[pos] = set[pos+1];
		size--;
	}
	
	/* Print the contents of the set in sorted order. */
	public void print() {
		for (int i = 0; i < size; i++)
			System.out.print(set[i] + " ");
		System.out.println();
	}
}
