package Searching;

import java.util.Scanner;

/***
 * This class implements linear search by recursion
 * @author Mohua
 *
 */
public class searchByRecursion {
	public boolean search(int[] arr, int key, int i){
		if(key==arr[i]){
			return true;
		}else{
			return search(arr,key, i+1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1, 3, 4, 5, 7, 8, 9, 10, 12, 13, 16, 17, 27};		
		System.out.println("Enter the element to be searched");
		Scanner sc=new Scanner(System.in);
		int key=sc.nextInt();
		searchByRecursion sr=new searchByRecursion();
		System.out.println(sr.search(arr, key, 0));
		
		

	}

}
