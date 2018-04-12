package datastructures;
/***
 *Implementation of Merge sort
 * @author Mohua
 *
 */
public class mergesort {
	public static void merge(int[] arr, int lo, int mid, int hi){
		System.out.println("Merge for lo "+lo+" mid "+mid+" hi "+hi);
		int n1=mid-lo+1;
		int n2=hi-mid;
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		for(int i=0;i<=n1-1;i++){
			L[i]=arr[lo+i];
		}
		for (int j=0; j<=n2-1;j++){
			R[j]=arr[mid+1+j];
		}
		L[n1]=999999;
		R[n2]=9999999;
		int i=0,j=0;
		for(int k=lo;k<=hi;k++){
			if(L[i]<R[j]){
				arr[k]=L[i];
				i++;
			}else{
				arr[k]=R[j];
				j++;
			}
		}
		for (int x: arr){
			System.out.print(x+" ");
		}
		System.out.println();
		
	}
public static void sort(int[] arr, int lo, int hi){
	if(lo<hi){
		int mid=(lo+hi)/2;
		System.out.println("lo "+lo+" mid "+mid+" hi "+hi);
		sort(arr, lo,mid);
		sort(arr, mid+1,hi);
		merge(arr,lo, mid,hi);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={3, 41, 52, 26, 38, 57, 9, 49};
		int mid=(0+arr.length-1)/2;
		sort(arr, 0, arr.length-1 );

	}

}
