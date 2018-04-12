package datastructures;
/***
 * Implementation of Selection sort
 * @author Mohua
 *
 */
public class Selectionsort {
	private static int findMin(int[] arr, int index){
		int min = arr[index];
		int mindex=index;
		for (int i=index; i<arr.length;i++){
			if (min>arr[i]){
				min=arr[i];
				mindex=i;
			}
		}
		System.out.println("The min is "+min+" and the index is "+mindex);
		return mindex;
	}
	public static void sort(int[] arr){ 
		for (int i=0;i<arr.length;i++){ 
			int mindex=findMin(arr, i);
			int temp=arr[i];
			arr[i]=arr[mindex];
			arr[mindex]=temp;
			show(arr);
		}
	}
	private static void show(int[] arr){
		for(int x: arr){
			System.out.print(x+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={3, 41, 52, 26, 38, 57, 9, 49};
		sort(arr);

	}

}
