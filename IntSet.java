/*
 * This class maintains a set of ints. 
 */
public class IntSet {
	private static Node head;		// An array to represernt the set. This is always maintained in sorted order.
	private static Node cur;
	private static Node temp;
	//private int capacity;	// The maximum allocated memory for the set.
	//private int size;		// The number of elements currently stored in the set.
	
	public IntSet() {
		//size = 0;
		//capacity = 10;
		head = null;
		cur = null;
		temp = null;
		//instead of an array, we will need to build a linked list 
		//with the head pointing to the new linked list made from 
		//from the array passed in.
		//head = new Node((int) head, head); 
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
	/* 
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
	*/
	/* 
	public static Node arrToList(int[] head, int capacity) {
		Node head = null;
		for (int i = 0; i < capacity; ++i)
			head = insertNode(head, head[i]);
		return head;
	}
	*/
	/* Commenting out for now */
	/* Find if a key is present in the set. Returns true if the key is present, otehrwise false.*/
	/* 
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
	*/
	/* Insert a key into the list. */
	public static void insert(int key) {
		// Make sure that the key is not present.
		//assert (!find(key));<-- bring back in after defining "find"
		// Since we are using linked-list, size is
		// not crucial. We only need to watch for 
		// the end of the list (null).

		// Perform insert.
		// Insert in sorted order.
		Node cur = head;
		if ( head == null) {
			head = new Node(key, null);
			System.out.print("First node is "+head.digit);
			System.out.println();
			return;
		}
		while (cur != null) {
			
			/* ------------------------------------------------
			* Iterate through the list looking for "key"
			* There should be 3 cases: 
			* k < first-digit
			* smaller-digit < k > greater-digit
			* k > greatest-digit
			* 
			* First check if key < first-digit
			*  ------------------------------------------------
			*/
			//System.out.print("After the while key is "+key);
			//System.out.println();
			//If this is the only node, then we've already
			//created the node and need to skip the key
			if (cur.next != null) {
				System.out.print("Inside Stage 1 ");
				System.out.println();
				//System.out.print("The FIRST cur next digit is  "+cur.next.digit);
				//System.out.println();
				//if (key < head.digit) {
				//	temp = new Node(key, head);
				//	head = temp;
				//}
				while (cur.next != null && key > cur.next.digit) {
					cur = cur.next;
					if (cur.next != null) {
					//System.out.print("The ALTERED cur next digit is  "+cur.next.digit);
					//System.out.println();
					}
				}
				if (key > cur.digit) {
					System.out.print("Inside Stage 2 ");
					System.out.println();
					//System.out.print("The INSERT cur digit is  "+cur.digit);
					//System.out.println();
					//display(head);
					//System.out.println();
					//if (cur.next != null) {
					//	System.out.print("The ALTERED cur next digit is  "+cur.next.digit);
					//	System.out.println();
					//	}
					temp = new Node(key, cur.next);
					cur.next = temp;
					return;
				} else if (key < cur.digit) {
					head = new Node(key, head);//changed head to cur
					cur = head;
					System.out.print("Inside Stage 3 ");
					System.out.println();
					//display(head);
					//System.out.println();
					return;
					//cur.next = head;
				} else if (cur.next == null) {
					temp = new Node(key, null);
					cur.next = temp;
				}
			} else if (key > head.digit) {//takes care of key=5 and head=4
				temp = new Node(key, null);
				cur.next = temp;
				return;
			} else {
				head = new Node(key, head);
				System.out.print("The NEW node is  "+head.digit);
				System.out.println();
				//display(head);
				//System.out.println();
				return;
			} 
			/* 
			if (key < head.digit) {
				// Create a new head (head) with next pointing to 
				// the previous head.
				System.out.print(key+" is less than "+head.digit);
				System.out.println();
				head = new Node(key, head);
				// Make the new digit the key
				head.digit = key;
				System.out.print("Smallest node head is "+head.digit);
				System.out.println();
				System.out.print("The next digit is  "+head.next.digit);
				System.out.println();
			} else if (key > head.digit && key < head.next.digit) {
				System.out.print("The first digit is  "+head.digit);
				System.out.println();
				System.out.print("The next digit is  "+head.next.digit);
				System.out.println();
				System.out.print("The next NEXT digit is  "+head.next.next.digit);
				System.out.println();
			
				//Save the current head
				cur = head;
				//Create the new node and point it to the next node
				head = new Node(key, head);
				// Make the new digit the key
				head.digit = key;
				//Point the previous node to the inserted node
				head = cur.next;
				//head.next = head;
				System.out.print("Middle node head is "+head.digit);
				System.out.println();
			
			}  else {
				return;
			}
			*/
		}
	}
	/* Commenting out for now */
	/* Remove a key from the head. */
	/*
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
	*/
	/* Commenting out for now */
	/* Print the contents of the set in sorted order. */
	/*
	public void print() {
		for (int i = 0; i < size; i++)
			System.out.print(set[i] + " ");
		System.out.println();
	}
	*/
	static void display(Node head){
		while (head != null) {
				System.out.print( head.digit + " ");
				head = head.next;
		}
	}
	/* Main Test function */
	public static void main(String args[]) {
		System.out.print("Key = 4");
		System.out.println();
		insert(4);
		System.out.print("Key = 2");
		System.out.println();
		insert(2);
		System.out.print("Key = 1");
		System.out.println();
		insert(1);
		System.out.print("Key = 3");
		System.out.println();
		insert(3);
		System.out.print("Key = 0");
		System.out.println();
		insert(0);
		System.out.print("Key = 5");
		System.out.println();
		insert(5);
		display(head);
		System.out.println();
	}
}
