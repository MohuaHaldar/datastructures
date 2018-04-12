package datastructures;

import java.util.Scanner;
/***
 * Implementation of postfix evaluation
 * @author Mohua
 *
 */

public class PostfixEvaluation {
	
	public void postfixEval(String s, stack st){
		String[] items=s.split(" ");
		for(String c:items){
		
		if(c.equals("+")||c.equals("-")||c.equals("/")||c.equals("*")||c.equals("^")){
			int op1=Integer.parseInt(st.pop());
			int op2=Integer.parseInt(st.pop());
			int res;
			if(c.equals("+")){
				 res=(int)op2+(int)op1;				
			}else if(c.equals("-")){
				 res=(int)op2-(int)op1;
				
			}else if(c.equals("/")){
				 res=(int)op2/(int)op1;				
			}else if(c.equals("*")){
				 res=(int)op2*(int)op1;				
			}else{
				 res=(int)op2^(int)op1;							
			}
			st.push(String.valueOf(res));
			
		}else{
				 st.push(c);
			}
		}
		System.out.println(st.pop());
		
	}	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String size=in.nextLine();
		
		stack st=new stack(Integer.parseInt(size));
		String postfix=in.nextLine();
		PostfixEvaluation ob=new PostfixEvaluation();
		ob.postfixEval(postfix, st);

	}

}
