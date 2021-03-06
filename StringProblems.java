package datastructures;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StringProblems {
	
	/***
	 * This method reads an input string, eliminates the duplicate characters, 
	 * and prints the string in original order. Used LinkedHashMap to make the 
	 * map ordered.
	 * @param s
	 */
	public static void eliminateDuplicateCharacters(String s){
		Map<Character, Integer> CharTracker=new LinkedHashMap<Character, Integer>();
		
		for(int i=0; i<s.length();i++){
			if(CharTracker.containsKey(s.charAt(i))){
				continue;
			}else{
				CharTracker.put(s.charAt(i), 1);
				
			}
		}
		Set<Character> keys=CharTracker.keySet();
		for(Character key: keys){
			System.out.print(key);
		}
	}
	/***
	 * This method reads three string and returns true if the third string is made out of interleaving the 
	 * first and the second
	 * @param first
	 * @param second
	 * @param third
	 * @return
	 */
public static boolean validShuffle(String first, String second, String third){
	if(first.length()==second.length()){
		String res="";
		for( int i=0;i<first.length();i++){
			res=res+first.charAt(i)+second.charAt(i);
		}
		if(res.equals(third)){
			return true;
		}else{
			return false;
		}
	}else{
		System.out.println("The strings "+first+" and "+second+" do not match. ");
		return false;
	}
}
/***
 * This method displays the count of vowels and consonants in the input string
 * @param input
 */
public static void countVowelsAndConsonants(String input){
	int countOfVowels=0;
	int countOfConsonants=0;
	
		for(Character c: input.toCharArray()){
		if("aeiou".indexOf(c)>=0){
			countOfVowels++;			
		}else{
			countOfConsonants++;
		}
	}
		System.out.println("Count of vowels "+countOfVowels+"\n Count of consonants "+countOfConsonants);
	
	
	
}
/***
 * This method returns the reverse of the input string using recursion
 * @param input
 * @return
 */
public static String reverseString(String input){
	if(input.length()==1){
		return input;
	}else{
		return input.substring(input.length()-1)+reverseString(input.substring(0, input.length()-1));
	}
	
}
/***
 * This method returns the reverse of the input string using iteration
 * @param input
 * @return
 */
public static String reverseStringIter(String input){
	if(input==null||input.isEmpty()){
		return null;
	}else{
		String rev="";
		for(int i=input.length()-1;i>=0;i--){
			rev+=input.charAt(i);
		}
		return rev;
	}	
	
}
public static String replaceCharacter(String input){
	String[] splited=input.split("\\s+");
	String replaced="";
	for(String s: splited){
		System.out.println(s);
		replaced+=s+"%20";
	}
	return replaced.substring(0, replaced.length()-3);// removing the last '%20' characters
	
}
/***
 * This method removes the duplicate characters from a string without any extra buffers
 * @param s
 * @return
 */
public static String removeDuplicates(String s){
	if(s==null)
		return null;
	char[] rev=s.toCharArray();
	int i=1;
	while (i<rev.length){
		int j=0;
		while(j!=i){
			if(rev[j]!=rev[i]){
				
				j++;
			}else{
				rev[i]=0;
				i++;
				j=0;
			}
		}
		i++;
		
		
	}
	String s1="";
	for(char x: rev){
		if(x==0){
			continue;
		}
		else{
			s1+=x;
		}
	}
	return s1;
	
}
/***
 * This method checks if the matrix has 0 as any element, if so, it sets all the elements
 * in that row and column 0
 * @param matrix
 */
public static void setToZero(int[][] matrix){
	int [] col=new int[matrix[0].length];
	int [] row=new int[matrix.length];
	for(int i=0;i<row.length;i++){
		for(int j=0;j<col.length;j++){
			if(matrix[i][j]==0){
				row[i]=1;
				col[j]=1;
				
			}
		}
	}
	for(int k=0;k<row.length;k++){
		for(int l=0;l<col.length;l++){
			if(row[k]==1||col[l]==1){
				matrix[k][l]=0;
			}
			
		}
		System.out.println();
	}
	
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);		
		
		
		
		System.out.println("1. eliminate duplicate string");
		System.out.println("2. valid shuffle");
		System.out.println("3. Count vowels and consonants");
		System.out.println("4. Reverse by recursion");
		System.out.println("5. Reverse by iteration");
		System.out.println("6. Replace character");
		System.out.println("7. Remove duplicates without extra buffer");
		int n=sc.nextInt();
		switch(n){
			case 1: System.out.println("Enter the string ");
					String input=sc.next();
					eliminateDuplicateCharacters(input);					
					break;
			case 2: System.out.println("Enter the three strings");
					String s1=sc.next();
					String s2=sc.next();
					String s3=sc.next();
					System.out.println(validShuffle(s1,s2,s3));
					break;
			case 3: System.out.println("Enter the input string");
					String s4=sc.next();
					countVowelsAndConsonants(s4);
					break;
			case 4: System.out.println("Enter the input string to be reversed");
					String s=sc.next();
					System.out.println("The reversed string is "+reverseString(s));
					break;
			case 5: System.out.println("Enter the input string to be reversed");
					String s5=sc.next();
					System.out.println("The reversed string is "+reverseStringIter(s5));
					break;
			case 6: System.out.println("Enter the string");
					sc.nextLine();
					String ori=sc.nextLine();	
					System.out.println("The string after replaced character is "+replaceCharacter(ori));
					break;
			case 7: System.out.println("Enter the string with duplicate characters");
					System.out.println(removeDuplicates(sc.next()));
					break;
					
			case 8: System.out.println("Enter the values of M and N");
					int M=sc.nextInt();
					int N=sc.nextInt();
					int[][] matrix=new int[M][N];
					System.out.println("Enter the elements of matrix");
					for(int i=0;i<M;i++){
						for(int j=0;j<N;j++){
							matrix[i][j]=sc.nextInt();
						}
					}
					setToZero(matrix);
					break;
					
					
					
				
		}
				
		

	}

}
