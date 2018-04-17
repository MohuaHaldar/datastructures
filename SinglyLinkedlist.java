package datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/***
 * Implememtation of singly linked list
 * @author Mohua
 *
 */
class LNode{
	LNode next;
	int key;
	public LNode(int key){
		this.key=key;
		this.next=null;
	
}
}
public class SinglyLinkedlist {
	
	public  LNode head=null;		
	
	/***
	 * This method inserts a node at the head of the list
	 * @param head
	 * @param x
	 * @return 
	 */
	public  void insert( int x){
		LNode n=new LNode(x);
		if(this.head==null){
			this.head=n;
			
		}else{
			n.next=this.head;
			this.head=n;
		}
		
	}
	/***
	 * This method prints the list
	 * @param head
	 */
public void printList(){
	LNode t=this.head;
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
public LNode search( int key){
	LNode t=head;
	
	while(t.key!=key && t.next!=null){
		
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
public LNode delete( int key){
	if(head!=null){
		LNode p=search(key);
		if(p==head){
			head=p.next;
			p=null;
			
		}else{
			
			p=p.next.next;
			
			
		}	
		printList();
	}else{
		System.out.println("Ounch the list is empty!!!");
	}
	return head;
	
	
}
/***
 * This method removes the duplicate nodes from an unsorted array
 */
public void removeDuplicates(){
	LNode prev=head;
	LNode curr=prev.next;
	while(curr!=null){
		LNode p=head;
		while(p!=curr){
			if(p.key==curr.key){
				LNode temp=curr.next;
				prev.next=temp;
				curr=temp;
			}
			p=p.next;
		}
		if(p==curr){
			prev=curr;
			curr=curr.next;
		}
	}
	printList();
	
}
/***
 * This method prints the nth to the end of the linked list
 * @param nth
 */
public void NthToLast(int nth){
	LNode temp=head;
	int count=1;
	while(temp!=null){
		if(count==nth){
			while(temp!=null){
				System.out.print(temp.key+"->");
				temp=temp.next;
			}
			System.out.println();			
			break;
		}else{
			temp=temp.next;
			count++;
		}		
	}
}
/***
 * This method takes a number, parses the digits and returns an array of the digits in reverse order
 * @param num
 * @return
 */
private static int[] parseDigits(int num){
	int rem=0;
	List<Integer> list=new ArrayList<Integer>();
	while(num!=0){
		rem=num%10;
		list.add(rem);
		num=num/10;
	}
	int size=list.size();
	int[] arr=new int[size];
	int i=0;
	Iterator<Integer> iter=list.iterator();
	while(iter.hasNext()){
		arr[i++]=iter.next();		
	}	
	return arr;
}
/***
 * This method takes an integer array and creates a linked list
 * @param arr
 */
private void createLL(int[] arr){
	for(int x:arr){
		this.insertAtEnd(x);
		
	}
}
/***
 * This method adds a new node at the tail of the linked list
 * @param x
 */
public void insertAtEnd(int x){
	LNode temp=this.head;
	LNode n=new LNode(x);
	if(this.head==null){
		this.head=n;
	}else{
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=n;
		
	}
	
}
/***
 * This method adds two nodes from two linked lists and retuns a third list
 * @param n1
 * @param n2
 * @param carry
 * @return
 */
private SinglyLinkedlist addNodes(LNode n1, LNode n2, int carry){
	int sum=carry;
	if(n1!=null){
		sum+=n1.key;
	}
	if(n1!=null){
		sum+=n2.key;
		
	}
	this.insertAtEnd(sum%10);
	if(n1!=null||n2!=null||sum>=10){
		return this.addNodes(n1==null? null:n1.next, n2==null? null:n2.next, sum>=10? 1:0);
	}
	return this;
}
/***
 * This method adds two linked lists of same length node-wise and returns the sum in a new linked list
 * @param num1
 * @param num2
 * @return
 */
public static SinglyLinkedlist sumLists(int num1, int num2){
	SinglyLinkedlist L1=new SinglyLinkedlist();
	SinglyLinkedlist L2=new SinglyLinkedlist();
	SinglyLinkedlist L3=new SinglyLinkedlist();
	L1.createLL(parseDigits(num1));
	L1.printList();
	L2.createLL(parseDigits(num2));
	L2.printList();
			
	LNode n1=L1.head;
	LNode n2=L2.head;
	return L3.addNodes(n1, n2, 0);
	
}
public int size(){
	int c=0;
	LNode t=this.head;
	while(t!=null){
		c++;
		t=t.next;
	}
	return c;
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedlist L=new SinglyLinkedlist();
		Scanner in=new Scanner(System.in);
		
	/*	int[] arr={3, 41, 52, 26, 38, 57, 9, 49,41, 52};
		for(int x:arr){
			head=L.insert(x);
		}
		L.printList();*/
		
	
	System.out.println("1. Search");
	System.out.println("2. Enter the key to be deleted.");
	System.out.println("3. Remove duplicate keys.");
	System.out.println("4. Find nth to last element.");
	System.out.println("5. Sum two numbers.");
	
	int x;
	x=in.nextInt();
	switch(x){
		case 1:	System.out.println("Enter the key to be searched. Enter 999 to exit loop.");
				while((x=in.nextInt())!=999){
					L.search( x);			
				}
				break;
			
		case 2: System.out.println("Enter the key to be deleted. Enter 999 to exit loop.");
				while((x=in.nextInt())!=999){
					L.head=L.delete( x);
			
				}
				break; 
				
		case 3: L.removeDuplicates();
				break;
		case 4: System.out.println("Enter the nth node");
				x=in.nextInt();
				L.NthToLast(x);
				break;
		case 5: System.out.println("Enter the first number");
				int num1=in.nextInt();
				System.out.println("Enter the second number");
				int num2=in.nextInt();
				SinglyLinkedlist res=sumLists(num1, num2);
				res.printList();
	}
	
	
	

}
}
