package datastructures;

import java.util.Scanner;
/***
 * Implementation of infix to postfix conversion
 * @author Mohua
 *
 */

 class stack {
	private char[] data;
	private int top;
	
	stack(int len){
		data=new char[len];
		top=-1;
	}
	private boolean isEmpty(){
		if(top==-1){
			
			return true;
		}else{
			return false;
		}
	}
	private int size(){
		return data.length;
	}
	private boolean isFull(){
		if(top==size()-1){
			
			return true;
		}else{
			return false;
		}
	}
	public void push(char item){
		if(isFull()){
			System.out.println("Overflow...");
		}else{
			data[++top]=item;
		}
	}
	public char pop(){
		if(isEmpty()){
			System.out.println("Underflow...");
			return 0;
		}else{
			return data[top--];
			
		}
	}
	public void printStack(){
		for(char x:data){
			System.out.print(x+" ");
		}
	}
 }
	
	
public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the stack size ");
		int size=in.nextInt();
		
		stack st=new stack(size);
		System.out.println("Enter the input string of characters ");
		String infix=in.next();
		String postfix="";
		
		for(char c: infix.toCharArray()){
			// if the item in the input string is an operator or opening bracket,
			// push into the stack
			if(c=='('){
				st.push(c);
			}
			else if(c=='+' || c=='-'||c=='/' || c=='*'){
				st.push(c);
			}
			// if the item in the input is a closing bracket, pop all the items in the till
			// till you hit the opening bracket
			else if(c==')'){				
				char x;
				while((x=st.pop())!='('){
				
					postfix+=x;
				}				
				
			}
			// if the item in the input string is an operand, append it to the output string
			else{
				postfix+=c;
			}
			
		}
		// once the end of string is reached,pop all the items off the stack and append them
		// to the output string
		char item;
		while((item=st.pop())!=0){
			postfix+=item;
			
		}
		System.out.println(postfix);
	}

	

}
