package Searching;

import java.util.Scanner;
/***
 * This program implements binary search
 * @author Mohua
 *
 */
public class BinarySearch {
	public int search(int [] arr, int lo, int hi, int key){
		if(lo<=hi){
			int mid =(lo+hi)/2;
			if(key==arr[mid]){
				return mid;
				
			}else if(key<arr[mid]){
				
					return search(arr, lo, mid-1, key);
				}
			else{
					return search(arr, mid+1, hi, key);
				}
			
			
		}else{
			return -1;
		}
	
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={0, 1, 3, 4, 5, 7, 8, 9, 10, 12, 13, 16, 17, 27};
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number to be searched ");
		int num=sc.nextInt();
		BinarySearch bs=new BinarySearch();
		System.out.println("The position is "+bs.search(arr, 0, arr.length-1, num));
		

	}

}
