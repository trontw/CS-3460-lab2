import java.util.*;
public class IntArr {
/*
        private int [] set;// An array to represernt the set. This is always maintained in sorted order.
        private int capacity;// The maximum allocated memory for the set.
        private int size;// The number of elements currently stored in the set.

        public IntSet() {
                size = 0;
                capacity = 10;
                set = new int [capacity];
        }
*/
        static void display(Node head){
                while (head != null) {
                        System.out.print( head.digit + " ");
                        head = head.next;
                }
        }

        public static Node arrToList(int[] set, int n) {
                Node head = null;
                int digit;
                for (int i = 0; i < n; ++i) {
                       head = new Node(set[i], head);
                       //Trouble shooting code
                       digit = set[i];
                       System.out.print("set = "+digit);
                       System.out.println();
                }
                return head;//returns head->linked-list
        }
	// Driver code
	public static void main(String args[]){
    		//int arr[] = { 1, 2, 3, 4, 5 };
                int arr[] = { 5, 4, 3, 2, 1 };
    		int n = arr.length;
    		Node root = arrToList(arr, n);
    		display(root);
                System.out.println();
	}	
}
