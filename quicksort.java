package datastructures;
/***
 *Implementataion of Quick sort
 * @author Mohua
 *
 */
public class quicksort {
	public static void quick(int[] arr, int lo, int hi){
		System.out.println("Running quicksort for lo as "+lo+ " and hi as "+hi);
		if(lo<hi){
			int q=partition(arr, lo,hi);
			System.out.println("The index of the partition is "+ q);
			quick(arr,lo,q-1);
			quick(arr,q+1,hi);
		}
		for (int x : arr){
			System.out.print(x+" ");
		}
		System.out.println();
		
	}
	private static int partition(int[] arr, int lo, int hi){
		int x=arr[hi];
		int i=lo-1;
		for(int j=lo ;j<=hi-1;j++){
			if(arr[j]<=x){
				i=i+1;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
								
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[hi];
		arr[hi]=temp;
		return i+1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr={13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21};
		int[] arr={13, 13, 13, 13, 13, 13, 11, 13, 13, 13, 13, 13};
		quick(arr,0,11);

	}

}
