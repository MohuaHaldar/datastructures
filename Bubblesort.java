package datastructures;
/***
 *Implementation of Bubble sort
 * @author Mohua
 *
 */
public class Bubblesort {
	public static void sort(int[] arr){
		for(int i=0; i<arr.length;i++){
			System.out.println("i="+i);
			for(int j=arr.length-1; j>=i+1;j--){
				if(arr[j]<arr[j-1]){
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
					show(arr);
				}
			}
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
