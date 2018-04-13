package datastructures;

import java.util.Scanner;

/***
 * Implememtation of singly linked list
 * @author Mohua
 *
 */

public class SinglyLinkedlist {
	class ListNode{
		ListNode next;
		int key;
		public ListNode(int key){
			this.key=key;
			this.next=null;
		
	}
	
		
	}
	/***
	 * This method inserts a node at the head of the list
	 * @param head
	 * @param x
	 * @return 
	 */
	public  ListNode insert(ListNode head, int x){
		ListNode n=new ListNode(x);
		if(head==null){
			head=n;
			
		}else{
			n.next=head;
			head=n;
		}
		return head;
	}
	/***
	 * This method prints the list
	 * @param head
	 */
public void printList(ListNode head){
	ListNode t=head;
	while(t!=null){
		System.out.print(t.key+"->");
		t=t.next;
	}
	System.out.println();
}
/***
 * This method searches the list for a given key
 * @param head
 * @param key
 */
public ListNode search(ListNode head, int key){
	ListNode t=head;
	ListNode prev=head;
	while(t.key!=key && t.next!=null){
		prev=t;
		t=t.next;
	}
	if(t.key==key){
		System.out.println("Key found");
		return t;
	}else{
		System.out.println("Key not in list");
		return null;
	}
}
/***
 * This method deletes a given node from the list
 * @param head
 * @param key
 * @return
 */
public ListNode delete(ListNode head, int key){
	if(head!=null){
		ListNode p=search(head, key);
		if(p==head){
			head=p.next;
			p=null;
			
		}else{
			
			p=p.next.next;
			
			
		}	
		printList(head);
	}else{
		System.out.println("Ounch the list is empty!!!");
	}
	return head;
	
	
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedlist L=new SinglyLinkedlist();
		Scanner in=new Scanner(System.in);
		ListNode head=null;
		int[] arr={3, 41, 52, 26, 38, 57, 9, 49};
		for(int x:arr){
			head=L.insert(head,x);
		}
		L.printList(head);
	
	System.out.println("Enter the key to be searched. Enter 999 to quit the loop ");
	int x;
	while((x=in.nextInt())!=999){
		L.search(head, x);
		
	}
	System.out.println("Enter the key to be deleted. Enter 999 to quit the loop ");
	
	while((x=in.nextInt())!=999){
		head=L.delete(head, x);
		
	}

}
}
