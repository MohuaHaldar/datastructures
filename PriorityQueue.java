package datastructures;

import java.util.Scanner;

/***
 * This class implements priority queue using binary heaps. Source CLSR and the internet.
 * The program hasn't been tested for all flows and exceptions
 * @author Mohua
 *
 */

public class PriorityQueue {
	private int[] arr;
	private int heap_size;
	
	/***
	 * constructor with initial capacity
	 * @param capacity
	 */
	public PriorityQueue(int capacity){
		arr=new int[capacity];
		heap_size=0;		
	}
	/****
	 * Constructor without any initial capacity for the queue
	 */
	public PriorityQueue(){
		this(1);		
	}
	/***
	 * Constructor with an array that initializes the queue
	 * @param items
	 */
	public PriorityQueue(int[] items){
		heap_size=items.length;
		arr=new int[heap_size];
		for(int i=0;i<heap_size;i++){
			arr[i]=items[i];
		}
		for(int i=(heap_size/2)-1;i>=0;i--){
			maxHeapify(arr, heap_size, i);
		}
		
	}
	/***
	 * This method maintains the max heap structure
	 * @param arr
	 * @param heap_size
	 * @param i
	 */
	private void maxHeapify(int[] arr, int heap_size, int i) {
		int L=left(i);
		int R=right(i);
		int Largest;
		if(L<heap_size && arr[L]>arr[i]){
			Largest=L;
		}else{
			Largest=i;
		}
		if(R<heap_size && arr[R]>arr[Largest]){
			Largest=R;
		}
		if(Largest!=i){
			int temp=arr[Largest];
			arr[Largest]=arr[i];
			arr[i]=temp;
			maxHeapify(arr, heap_size,Largest);
		}
		
		
	}
	/***
	 * This method resizes the array after it has used up its initial capacity.
	 * After a new space is secured, the data of the older array is copied to the
	 * new one.
	 * @param newcap
	 * @return
	 */
	private int[] resize(int newcap){
		int[] newarr=new int[newcap];
		for(int i=0;i<arr.length;i++){
			newarr[i]=arr[i];
		}
		return newarr;
		
	}
	
	/***
	 * This method swaps two items of an array
	 * @param arr
	 * @param Largest
	 * @param i
	 * @return
	 */
	private int[] swap(int[] arr, int Largest, int i) {
		int temp=arr[Largest];
		arr[Largest]=arr[i];
		arr[i]=temp;
		return arr;
		
	}
	/***
	 * This method returns the right child of the item i
	 * @param i
	 * @return
	 */
	private int right(int i) {
		// TODO Auto-generated method stub
		return 2*i+2;
	}
	/***
	 * This method returns th eleft child of i
	 * @param i
	 * @return
	 */
	private int left(int i) {
		// TODO Auto-generated method stub
		return 2*i+1;
	}
	/***
	 * This method inserts a new item in the priority queue
	 * @param x
	 */
	public void insert(int x){
		 
		if(heap_size==this.arr.length){
			arr=resize(2*arr.length);
		}
		arr[heap_size]=-99999999;
		increment(heap_size, x);
		heap_size++;
		
		
		
	}
	/***
	 * This method replaces the key of item i by the value x
	 * @param i
	 * @param x
	 */
	public void increment( int i, int x) {
		if(x<arr[i]){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			arr[i]=x;
			int par=parent(i);
			while(i>0 && arr[par]<arr[i]){
				int temp=arr[par];
				arr[par]=arr[i];
				arr[i]=temp;
				i=par;
				par=parent(i);
				
			}
		}
		
	}
	/***
	 * This method returns the parent of the index i.
	 * @param i
	 * @return
	 */
	private int parent(int i) {
		// TODO Auto-generated method stub
		if (i%2==0)
			return (i/2)-1;
		else
			return i/2;
	}
	public int extractMax(){
		int max=arr[0];
		if(heap_size<=0){
			try {
				throw new Exception("The queue is empty");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		arr=swap(arr, 0, heap_size-1);
		heap_size=heap_size-1;
		maxHeapify(arr, heap_size, 0);
		return max;
	}
	/***
	 * This method prints the heap
	 */
	public void printArray(){
		 for(int i=0;i<heap_size;i++){
		       
		            System.out.print(this.arr[i]+" ");	        
		       
		    }
		 System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue pq;
		
		int[] temp={27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
		pq=new PriorityQueue(temp);
		pq.printArray();
		Scanner sc=new Scanner(System.in);
		System.out.print("1. Create empty priority queue\n2. Insert\n3. Extract max.\nPrint 999 to exit loop");
		int choice; 
		while((choice=sc.nextInt())!=999){
			switch(choice){
			case 1: pq=new PriorityQueue();
					pq.printArray();
					break;
			case 2: pq.insert(sc.nextInt());
					pq.printArray();
					break;
			case 3: System.out.println(pq.extractMax());
					pq.printArray();
			}
		}
		

	}

}
