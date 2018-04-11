import java.util.HashSet;

public class LinkedLists {
	
	Node head;	
	
	public class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
		
		void insertAtTail(int data) {
			Node newNode = new Node(data);
			Node current = head;
			while(current.next!=null) {
				current = current.next;
			}
			current.next = newNode;			
		}
		
		void insertAtHead(int data) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
		
		void print() {
			Node current = head;
			
			while(current!=null) {
				System.out.println(current.data+" -> ");
				current = current.next;
			}
		}
		
		void deleteNode(int data) {
			Node current = head;
			
			//if the head node needs to be deleted, make the head.next node as the head node
			if(data == head.data) {
				head = head.next;
				return;
			}
			
			while(current.next!=null) {
				if(current.next.data == data) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
		}
		
		//Challenge 1: Weave
		void weave() {
			Node p1,p2;
			p1=p2= head;
			
			while(p2.next.next!=null) {
				p1 = p1.next;
				p2 = p2.next.next;
			}
			
			p2= head;
			
			System.out.println("p1 is: " +p1.data);
			System.out.println("p2 is : " +p2.data);
			
			while(p1.next.next!=null) {
				Node temp;
				
				temp = p1.next;
				p1.next = p1.next.next;
				
				temp.next = p2.next;
				p2.next = temp;				
				
				p2 = p2.next.next;
			}
			
			System.out.println("weave-------------------");
		}
		
		//Challenge 2: Remove duplicates from unsorted LinkedList
		void removeDupsUsingMap() {
			Node cur = head;
			HashSet<Integer> hs = new HashSet<Integer>();
						
			while(cur!=null) {
				if(hs.contains(cur.data)) {
					deleteNode(cur.data);
					// this delete Node function will again start looping in the lis from beginning
					//which is reduncdant
					//instead can implement deletion here
					//using previous node
					//see function below:
				}
				else{
					hs.add(cur.data);
				}				
				cur = cur.next;
			}			
		}
		
		void removeDupsUsingMap2() {
			Node cur = head;
			HashSet<Integer> hs = new HashSet<Integer>();
			Node prev = null;
						
			while(cur!=null) {
				if(hs.contains(cur.data)) {
					prev.next = cur.next;
				}
				else{
					hs.add(cur.data);
					prev = cur;
				}				
				cur = cur.next;
			}			
		}
		
		//implement this
		void removeDupsUsingPointers() {
			Node p1,p2;
			p1=head;			
		
		}
		
		//Challenge 3 : Return kth element from last
		//kth to last element
		//recursive solution
		int findKthFromLast(Node head, int k) {
			
			if (head == null) {
				return 0;
			}
			
			int index = findKthFromLast(head.next, k)+1;
			if(index == k) {
				System.out.println("The kth value from last is:"+ head.data);
			}
			return index;
			//return head;
		}
		
		//iterative solution		
		Node findKthFromLastIterative(int k) {
			Node p1 = head;
			Node p2 = p1;
			
			int count = 1;
			
			while(count!=k && p2!=null) {
				p2 = p2.next;
				count++;
			}
			
			if(p2 == null) {
				//invalid count
				return null;
			}
			while(p2.next!=null) {
				p1 = p1.next;
				p2 = p2.next;
			}
			
			return p1;			
		}
			
		//Challenge - 4 Sum List
		LinkedLists sumList(Node head1, Node head2) {
			
			LinkedLists result = new LinkedLists();
			result.head = new Node(0);
			Node current = result.head;
			
			int carry =0;
			while(head1 != null && head2 !=null) {
				
				current.next = new Node(0);				
				
				int sum = head1.data + head2.data + carry;
				carry = sum/10;
				sum = sum - carry*10;
				
				current.next.data = sum;
				current = current.next;
				head1 = head1.next;
				head2 = head2.next;
			}
			
			while(head1 != null) {
				current.next = new Node(0);	
				int sum = head1.data+ carry;
				carry = sum/10;
				sum = sum - carry*10;
				
				current.next.data = sum;
				current = current.next;
				head1 = head1.next;				
			}
			
			while(head2 != null) {
				current.next = new Node(0);	
				int sum = head2.data + carry;
				carry = sum/10;
				sum = sum - carry*10;
				
				current.next.data = sum;
				current = current.next;				
				head2 = head2.next;
			}
			
			if(carry == 1) {
				current.next = new Node(1);
			}
			
			return result;
		}
		
		//Challenge 5 - Check if a LinkedList is a palindrome or not
		boolean checkIfPalindrome() {
			
			
			return true;
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*LinkedLists list1 = new LinkedLists();
		
		list1.head = list1.new Node(10);
		
		list1.insertAtTail(20);
		list1.insertAtTail(30);
		list1.insertAtTail(40);
		list1.insertAtTail(50);
		list1.insertAtTail(60);
		list1.insertAtTail(70);
		list1.insertAtTail(80);*/
				
		/*To test the "weave" challenge
		 * list1.insertAtTail(100);
		list1.insertAtTail(200);
		list1.insertAtTail(300);
		list1.insertAtTail(400);
		list1.insertAtTail(500);
		list1.insertAtTail(600);
		list1.insertAtTail(700);
		list1.insertAtTail(800);
		 
		list1.weave();*/		
		
		/*To test the remove DUPs challenge
		list1.insertAtTail(50);
		list1.insertAtTail(60);
		list1.insertAtTail(70);
		list1.insertAtTail(80);
		list1.insertAtTail(250);
		list1.insertAtTail(260);
		list1.insertAtTail(270);
		list1.insertAtTail(250);
		list1.removeDupsUsingMap2();*/
		
		//list1.print();
		
		//to test findKthFromLast
		//System.out.println("kth index from last is : "+list1.findKthFromLast(list1.head,0));
				
		//to test findKthFromLastIterative
		/*Node result = list1.findKthFromLastIterative(8);
		
		if(result == null) {
			System.out.println("Invalid Count");
		}
		else {
			System.out.println("result is: "+result.data);
		}*/
		
		LinkedLists list1 = new LinkedLists();
		LinkedLists list2 = new LinkedLists();
		list1.head = list1.new Node(9);
		list1.insertAtTail(9);
		//list1.insertAtTail(3);
		
		list2.head = list1.new Node(9);
		//list2.insertAtTail(5);
		//list2.insertAtTail(7);
				
		
		LinkedLists result = list1.sumList(list1.head,list2.head);
		result.print();
	}

}
