package Searching;

import java.util.Scanner;

public class JumpSearch {
	
	public int search(int[] arr, int jump, int key){
		int i=0;int j=0;
		// While the key is greater than the current array value
		while(i<=arr.length-1 && key>arr[i]){
			j=i;
			i+=jump;
			
		}
		if(key==arr[i])
			return i;
		// Once the interval is found, perform a linear search to locate the key
		if(key>arr[j]){
			for(int k=j+1;k<i;k++){
				// if the array ends, return -1
				if(k>arr.length-1)
					return -1;
				if(key==arr[k]){
					return k;
				}
					
				
			}
		}
		return -1;		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1, 3, 4, 5, 7, 8, 9, 10, 12, 13, 16, 17, 27};
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number to be searched ");
		int num=sc.nextInt();
		JumpSearch js=new JumpSearch();
		System.out.println("Enter jump number ");
		int jump=sc.nextInt();
		System.out.println("The position is "+js.search(arr, jump, num));
		
	}

}
