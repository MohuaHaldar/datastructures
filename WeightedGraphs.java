package graph;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge {
	private int startVertex;
	private int endVertex;
	private Double weight;
	
	Edge(int start, int end,double weight){
		startVertex=start;
		endVertex=end;
		this.weight=weight;
	}
	public int getU(){
		return startVertex;
	}
	public int getV(){
		return endVertex;
	}
	public Double getW(){
		return this.weight;
	}
	
}
class Vertex implements Comparable<Vertex>{
	int value;
	Double key;
	int parent;
	Vertex(int value, Double key, int parent){
		this.value=value;
		this.key=key;
		this.parent=parent;
	}
	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return this.key.compareTo(o.key);
	}
	
	
}
public class WeightedGraphs {
	private int vertices;
	private LinkedList<Edge>[] AdjList;
	
	public WeightedGraphs(int V){
		this.vertices=V;
		AdjList=new LinkedList[V];
		for(int i=0;i<V;i++){
			AdjList[i]=new LinkedList<Edge>();
		}
		
	}
	public void addEdge(Edge e){
		AdjList[e.getU()].add(e);
		AdjList[e.getV()].add(e);
	}
	public void printGraph(){
		for(int i=0;i<this.vertices;i++){
			System.out.print("The lists of vertices from vertex " +i+ " is ");
			for(Edge node: this.AdjList[i]){
				System.out.print("->"+node.getV());
			}
			System.out.println();
		}
		
	}
	public void MSTPrim(int r){
		Double[] keys=new Double[this.vertices];
		int[] parent=new int[this.vertices];
		PriorityQueue<Vertex> MinQ=new PriorityQueue<Vertex>();
		Vertex[] vertices=new Vertex[this.vertices];
		// color all the vertices to white
		for(int i=0;i<this.vertices;i++){
			vertices[i]=new Vertex(i,99999999999.0,-1);
			
		}
		// keep the key of the vertex r as 0, to make it the starting point
		vertices[0].key=0.0;
		// keep all the vertices into the min priority queue
		for(int i=0;i<this.vertices;i++){
			MinQ.add(vertices[i]);
		}
		
		// while the queue is not empty, extract the vertex with minimum weight
		while(!MinQ.isEmpty()){
			Vertex d=MinQ.remove();
			// get the index of the vertex with minimum weight
			int index=d.value;
			
			// for every vertex v in the adjacency list of vertex index
			// compare if the vertex v is in the queue and if its key value is less than the weight of u-v
			
			for(Edge e: AdjList[index]){
				if( MinQ.contains(vertices[e.getV()]) && vertices[e.getV()].key>e.getW()){
					MinQ.remove(vertices[e.getV()]);					
					vertices[e.getV()].key=e.getW();
					vertices[e.getV()].parent=d.value;
					MinQ.add(vertices[e.getV()]);
					
					
				}
				
			}
			
		}
		for(int i=0;i<this.vertices;i++){
			System.out.println("parent of vertex "+i+ " is "+vertices[i].parent+" Weight is "+vertices[i].key);
			
		}
	}
	private int getIndex(Double[] keys, double val){
		int index = -1;
		for(int i=0; i<keys.length;i++){
			if(keys[i]==val){
				index=i;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fs = null;
		try{
			fs=new FileInputStream(new File("C:\\Users\\Mohua\\workspace\\ThreadsExample\\src\\graph\\DirectedWtData.txt"));
		}catch(Exception e){
			e.printStackTrace();
		}
		Scanner sc=new Scanner(fs);
		int V=sc.nextInt();
		WeightedGraphs G=new WeightedGraphs(V);
		int E=sc.nextInt();
		while(sc.hasNext()){
			int u=sc.nextInt();
			int v=sc.nextInt();
			double w=sc.nextDouble();
			Edge e=new Edge(u,v,w);
			G.addEdge(e);
		}
		System.out.println("1. Print Graph\n 2. Prim's\n 4. DFS");
		sc=new Scanner(System.in);
		switch(sc.nextInt()){
		case 1: G.printGraph();
				break;
		case 2: G.MSTPrim(0);
				break;
		}
		
	}

}
