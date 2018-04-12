package datastructures;

import java.util.Scanner;

public class stacks {
	private int[] data;
	private int top;
	
	stacks(int len){
		data=new int[len];
		top=-1;
	}
	
	/**
	 * This method checks whether the stack is empty
	 * @return
	 */
	private boolean isEmpty(){
		if(top==-1){
			
			return true;
		}else{
			return false;
		}
	}
	/**
	 * This method returns the size of the stack
	 * @return
	 */
	private int size(){
		return data.length;
	}
	/**
	 * This method checks whether the stack is full
	 * @return
	 */
	private boolean isFull(){
		if(top==size()-1){
			
			return true;
		}else{
			return false;
		}
	}
	/**
	 * This method pushes the item into the stack if the stack is not full
	 * @param item
	 */
	public void push(int item){
		if(isFull()){
			System.out.println("Overflow...");
		}else{
			data[++top]=item;
		}
	}
	/**
	 * This method pops an item off the stack is the stack is not empty
	 * @return
	 */
	public int pop(){
		if(isEmpty()){
			System.out.println("Underflow...");
			return -1;
		}else{
			int x=data[top];
			data[top]=0;
			top--;
			return x;
			
		}
	}
	/**
	 * This method prints all the items in the stack
	 */
	public void printStack(){
		for(int x:data){
			System.out.print(x+" ");
		}
	}
 public static void main(String[] args){
	 Scanner input=new Scanner(System.in);
	 System.out.println("Enter the size of the stack ");
	 int size=input.nextInt();
	 stacks st=new stacks(size);
	 int x;
	 System.out.println("Enter the integer elements of stack.To quit the loop enter 000");
	 while((x=input.nextInt())!=000){
		
		 st.push(x);
		 st.printStack();
	 }
 }
}

