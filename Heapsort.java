package datastructures;
/***
 * This class implements heapsort using binary heaps. Source CLSR and the internet
 * @author Mohua
 *
 */


public class Heapsort {
	
	/***
	 * This method creates a binary heap from an unordered array
	 * @param arr
	 */
	public void buildMaxHeap(int[] arr){
		int heap_size=arr.length;
		for(int i=heap_size/2-1;i>=0;i--){
			maxHeapify(arr,heap_size,i);
		}
	}
	/***
	 * This method maintain the max heap structure 
	 * @param arr
	 * @param size
	 * @param i
	 */
	private void maxHeapify(int[] arr,int size, int i) {
		int L=left(i);
		int R=right(i);
		int Largest;
		if(L<size && arr[L]>arr[i]){
			Largest=L;
		}else{
			Largest=i;
		}
		if(R<size && arr[R]>arr[Largest]){
			Largest=R;
		}	
		if(Largest!=i){
			int temp=arr[Largest];
			arr[Largest]=arr[i];
			arr[i]=temp;
			maxHeapify(arr,size, Largest);		
			
		}		
		
	}
	/***
	 * This method returns the index of the right child of i
	 * @param i
	 * @return
	 */
	private int right(int i) {
		// TODO Auto-generated method stub
		return 2*i+2;
	}
	/***
	 * This method returns the index of the left child of i
	 * @param i
	 * @return
	 */
	private int left(int i) {
		// TODO Auto-generated method stub
		return 2*i+1;
	}
	/***
	 *  prints the heap
	 * @param arr
	 */
	public void printArray(int[] arr){
		 for(int i=0;i<arr.length;i++){
		       
		            System.out.print(arr[i]+" ");	        
		       
		    }
		 System.out.println();
	}
	/***
	 * This method sorts the array using the heap operations
	 * @param arr
	 */
	public void sort(int[] arr){
		buildMaxHeap(arr);		
		for(int i=arr.length-1;i>=0;i--){			
			int temp =arr[i];
			arr[i]=arr[0];
			arr[0]=temp;			
			maxHeapify(arr,i, 0);
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
		Heapsort h=new Heapsort();
		h.sort(arr);
		h.printArray(arr);
	}

}
