//The program BigInt
public class BigInt {
	private Node head;
	//given a list "314159"
	//want to create a linked list in reverse
	//3<-1<-4<-1<-5<-9<-head 
	public BigInt(String number) {
		//Initialize head to point to null
		head = null;
		//Traversing the string from left to right	
		for (int i = 0; i < number.length(); ++i) {
			char c = number.charAt(i);
			//Error checking to make sure we have a non-negative number
			if (c < '0' || c > '9') 
				throw new IllegalArgumentException("input contains non-numeric data");
			
			head = new Node((int) c - (int)'0', head);
		}
	}
	
	public void add(BigInt lhs, BigInt rhs) {
		Node liter = lhs.head;
		Node riter = rhs.head;

		if (liter == null || riter == null) {
			if (liter == null && riter == null) {
		        	head = null;
				return;  	
			}
			// One of the lists is not empty. copy it.
			//Determine which side is not null
			//TERNARY OPERATOR
			// if the enclosed statement is T, then liter, if F, then riter
			liter = (liter != null) ? liter : riter;
			// shallow copy would be -> head = liter?
			// DEEP COPY would be this:
			head = new Node(liter.digit, null);
			liter = liter.next;
			Node cur = head;
			while (liter != null) {
				cur.next = new Node(liter.digit, null);
				cur = cur.next;
				liter = liter.next;
			}
			return;
		}
		// Do the addition
		int sum = liter.digit + riter.digit;
		int digit = sum % 10;//gives the digit
		int carry = sum / 10;//give the carry

		head = new Node(digit, null);
		liter = liter.next;
		riter = riter.next;
		Node cur = head;
		
		while (liter != null && riter != null) {
			sum = liter.digit + riter.digit + carry;
			digit = sum % 10;
			carry = sum / 10;
			
			cur.next = new Node(digit, null);
			cur = cur.next;
			liter = liter.next;
			riter = riter.next;
		}
		// add the digits of the longer list	
		liter = (liter != null) ? liter : riter;
		while (liter != null) {
			sum = liter.digit + carry;
			digit = sum % 10;
                        carry = sum / 10;

                        cur.next = new Node(digit, null);
                        cur = cur.next;
                        liter = liter.next;
		}
		if (carry == 1)
			cur.next = new Node(carry, null);
		
		
	}	

	public void print () {
		print(head);//call private print
		System.out.println();
	}
	
	private void print(Node x) {
		//keep track of the base case so we don't have stack overflow
		if (x == null) return;
		print(x.next);
		System.out.print(x.digit);
	}
}

