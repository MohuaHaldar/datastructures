package datastructures;

import java.util.Scanner;
/***
 * Implementation of stack using singly linked list
 * @author Mohua
 *
 */

/***
 * This class defines a node of the linked list
 * @author Mohua
 *
 */
 class ListNode {
	
		int value;
		ListNode next;
		public ListNode(int val){
			value=val;
			next=null;
		}

}
 /***
  * This class defines the stack operations
  * @author Mohua
  *
  */
public class StackWithList{
// static head in order to retain the changes to the list
 static ListNode head;

/***
 * This method returns a new node
 * @param x
 * @return
 */
private static ListNode getNode(int x){
		return new ListNode(x);
}
/***
 * This method pushes a new item on the stack
 * @param val
 */
public static void push(int val){
		ListNode n=getNode(val);
		if(head==null){
			head=n;
			
		}else{
			n.next=head;
			head=n;
		}
		printStack(head);
		
	}
/***
 * This method pops the top most item of the stack
 * @return
 */
	public static int pop(){
		int val=-1;
		if(head==null){
			System.out.println("The stack is empty");
			
		}else{
			val=head.value;
			ListNode n=head;
			head=head.next;
			n=null;
		}
		
		return val;		
	}
	/***
	 * This method prints the content of the stack
	 * @param head
	 */
	public static void printStack(ListNode head){
		ListNode n=head;
		while(n!=null){
			System.out.print(n.value+" ");
			n=n.next;
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] arr={3, 41, 52, 26, 38, 57, 9, 49};
		StackWithList stack=new StackWithList();	
		 
		for(int x :arr){
			stack.push(x);
			
		}
		int val = 0;
		while(val!=-1){
			
			 val=stack.pop();
			 System.out.println("Value poped is "+val);
		}
		
		
		
		
	}

	
}
