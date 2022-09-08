/*
 * This class maintains a set of ints. 
 */
public class IntSet {
	private static Node head;// A linked-list. This is always maintained in sorted order.
	private static Node cur; // cur is the current node
	private static Node temp;// temp is a temporary node
	
	public IntSet() {
		head = null;
		cur = null;
		temp = null;
	}

	/* -----------------------------------------------------
	*  Find if a key is present in the linked list. 
	*  Returns true if the key is present, otehrwise false.
	*  -----------------------------------------------------
	*/
	public static boolean find(int key) {
		while (cur.next != null) {
			if (key != cur.digit) {
				cur = cur.next;
			} else {
				return true;
			}
		}
		return false;
	}
	/* Insert a key into the list. */
	public static void insert(int key) {
		Node cur = head;
		// Make sure that the key is not present.
		assert (!find(key));

		// Perform insert.
		// Insert in sorted order.
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
					return;					
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
				return;
			} 
	
		}
	}
	/* Remove a key from the head. */
	public static void remove(int key) {
		Node prev = null;
		Node cur = head;
		// Make sure that the key is present.
		assert (find(key));
		System.out.print("INSIDE REMOVE");
		System.out.println();
		// Find the position of the key.
		if(head == null) {
			throw new IllegalArgumentException("List is Empty!!");
		}
		//First check the head to see if it is 
		//the digit to be removed.
		if(head.digit == key) {
    		head = head.next;
    	}
		//Next, loop through the list
		while (cur != null) {
			if (key != cur.digit) {
				//Move pointer to digit to be removed
				System.out.print("The REMOVE1 key is  "+key);
				System.out.println();
				System.out.print("The REMOVE1 cur.digit is  "+cur.digit);
				System.out.println();
				prev = cur;
				cur = cur.next;
				System.out.print("The REMOVE1 updated cur.digit is  "+cur.digit);
				System.out.println();
				//return;
			} else {//Key found, cur.next points to our digit
				// Perform remove.
				System.out.print("INSIDE REMOVE2");
				System.out.println();
				cur = prev.next;
				prev.next = cur.next;
				//prev.next = cur;
				System.out.print("The REMOVE2 prev.next.digit is  "+prev.digit);
				System.out.println();
				System.out.print("The REMOVE2 cur.next.digit is  "+cur.digit);
				System.out.println();
				return;
			}
		}
		
		
	}
	
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
		System.out.println();
		System.out.print("Remove 2");
		System.out.println();
		remove(2);
		display(head);
		System.out.println();
	}
}
