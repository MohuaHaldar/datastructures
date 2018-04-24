package graph;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
/***
 *This class defines a weighted digraph and implements Dijkstra's. Source CLSR
 * @author Mohua
 *
 */
class VertexD implements Comparable<VertexD>{
	int value;
	Double distance;
	int parent;
	VertexD(int val, Double dist, int par){
		value=val;
		distance=dist;
		parent=par;
	}
	@Override
	public int compareTo(VertexD o) {
		// TODO Auto-generated method stub
		return this.distance.compareTo(o.distance);
	}
	
}
/***
 * This class defines the structure of a weighted digraph
 * @author Mohua
 *
 */
public class WeightedDirectedGraph {
	private VertexD[] vertices;
	private int V;
	LinkedList<Edge>[] AdjList; 
	
	public WeightedDirectedGraph(int V){
		this.V=V;
		this.AdjList=new LinkedList[V];
		this.vertices=new VertexD[V];
		for(int i=0;i<V;i++){
			AdjList[i]=new LinkedList<Edge>();
		}
		
	}
/***
 * This method returns the number of vertices of the graph
 * @return
 */
public int getV(){
	return this.V;
}
/***
 * This method adds an edge to the adjacency list of the graph
 * @param e
 */
public void addEdge(Edge e){
	this.AdjList[e.getU()].add(e);
}
/***
 * This method finds the shorted single source path using Dijkstra's algo
 * @param source
 */
public void Dijkstras(int source){
	LinkedList<VertexD> S=new LinkedList();
	PriorityQueue<VertexD> MinQ=new PriorityQueue<VertexD>();
	
	initializeSingleSource(source);
	for(int i=0;i<this.V;i++){
		MinQ.add(this.vertices[i]);
	}
	while(!MinQ.isEmpty()){
		VertexD u=MinQ.remove();
		S.add(u);
		for(Edge e: this.AdjList[u.value]){			
			VertexD v=relax(u,this.vertices[e.getV()],e);
				
		}
	}
	this.printShortestPath();
	
}
/***
 * This method determines if a path to v is worth going through u
 * @param u
 * @param v
 * @param e
 * @return
 */
private VertexD relax(VertexD u, VertexD v,Edge e) {
	// TODO Auto-generated method stub
	if(v.distance>u.distance+e.getW()){
		v.distance=u.distance+e.getW();
		v.parent=u.value;
	}
	return v;
}
/***
 * This method initializes the vertices of the graph 
 * @param source
 */
private void initializeSingleSource(int source) {
	// TODO Auto-generated method stub
	for(int i=0;i<this.getV();i++){
		this.vertices[i]=new VertexD(i,9999999.0,-1);
		
	}
	this.vertices[source].distance=0.0;
	
}
public void printShortestPath(){
	Double sum=0.0;
	for(VertexD v: this.vertices){
		
		System.out.println("vertex "+v.value+"parent "+v.parent+"->"+" distance "+v.distance);
	}
}
public void printGraph(){
	for(int i=0;i<this.V;i++){
		System.out.print("The lists of vertices from vertex " +i+ " is ");
		for(Edge node: this.AdjList[i]){
			System.out.print("->"+node.getV());
		}
		System.out.println();
	}
	
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
		WeightedDirectedGraph G=new WeightedDirectedGraph(V);
		int E=sc.nextInt();
		while(sc.hasNext()){
			int u=sc.nextInt();
			int v=sc.nextInt();
			double w=sc.nextDouble();
			Edge e=new Edge(u,v,w);
			G.addEdge(e);
		}
		System.out.print("\n1.Dijkstras.\nEnter 999 to quit the loop");
		 sc=new Scanner(System.in);
		 int n;
		while((n=sc.nextInt())!=999){
			switch(n){
			case 1: G.Dijkstras(0);
					break;
			
			}
			
		}
		
	}

}
