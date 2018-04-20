package datastructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
/***
 * This class contains the methods of graph
 * @author Mohua
 *
 */
class GraphMethods{
	
	public static int generateVertices(int nodes){
		Random rand=new Random();
		int x=rand.nextInt(nodes);
		
		return x;
		
	}
	public static int[] createEdge( int[] vertices){
		Random rand=new Random();
		int[] edge={vertices[rand.nextInt(vertices.length)], vertices[rand.nextInt(vertices.length)]};
		return edge;
	}
	
}
public class Graph {
	public int[] vertices;
	private int nodes;
	private LinkedList<Integer>[] adjList;
	private char[] colors;
	private int[] parent;
	private int[] distance;
	
	public Graph(int nodes){
		this.nodes=nodes;
		this.vertices=new int[nodes];
		
		colors=new char[nodes];
		parent=new int[nodes];
		distance=new int[nodes];
		
		adjList=new LinkedList[nodes];
		for(int i=0;i<nodes;i++){
			adjList[i]=new LinkedList<Integer>();
		
			
		}
	}
	/***
	 * This method creates a array of vertices
	 */
	public void addVertices(int nodes){
		for(int i=0;i<nodes;i++){
			
				this.vertices[i]=i;
			
					
		}
		
		
	}
	private boolean exists(int[] arr, int x){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==x)
				return true;
		}
		
		return false;		
	}
	
	/***
	 * This method creates a adjacency list
	 * @param edge
	 */
	public void createAdjacencyList(int[] edge){
		adjList[edge[0]].add(edge[1]);
		
		
	}
	/***
	 * This method calculates the out degree for every node
	 */
	public void outDegree(){
		for(int i=0;i<adjList.length;i++){
			System.out.println("The out degree of "+" vertex "+i+" is "+adjList[i].size());
		}	
	
	}
	/***
	 * This method performs breadth first search
	 * @param vertex
	 */
	public void breathFirstSearch(int vertex){
		LinkedList<Integer> Q=new LinkedList<Integer>();
		// color all the vertices sin the graph except vertex as white
		for(int i=0;i<this.nodes;i++){
			if(i!=vertex){
				this.colors[i]='W';
				this.distance[i]=999999;
				this.parent[i]=-1;
			}
		}
		this.colors[vertex]='G';
		this.distance[vertex]=0;
		this.parent[vertex]=-1;
		Q.add(vertex);
		while(!Q.isEmpty()){
			int u=Q.removeFirst();
			for(int v: this.adjList[u]){
				if(this.colors[v]=='W'){
					this.colors[v]='G';
					this.distance[v]=this.distance[u]+1;
					this.parent[v]=u;
					Q.add(v);
				}
			}
			this.colors[u]='B';
		}
		
		
		
	}
	/***
	 * This method decides if a path exists between the given two vertices
	 * @param u
	 * @param v
	 * @return
	 */
	public boolean isPath(int u, int v){
		this.breathFirstSearch(u);
		if(this.colors[v]=='B')
			return true;
		else
			return false;
	}
	/***
	 * This method prints the graph
	 */
	public void printGraph(){
		for(int i=0;i<nodes;i++){
			System.out.print("The lists of vertices from vertex " +this.vertices[i]+ " is ");
			for(int node: adjList[i]){
				System.out.print("->"+node);
			}
			System.out.println();
		}
		
		
	}
	/***
	 * This method performs the depth first search
	 */
	public void depthFirstSearch(){
		for(int i=0;i<this.vertices.length;i++){
			colors[i]='W';
			parent[i]=-1;
		}
		for(int i=0;i<this.vertices.length;i++){
			if(colors[i]=='W'){
				DFS_Visit(i);
			}
		}
		
	}
	/***
	 * This method visits each vertex recursively
	 * @param vertex
	 */
	private void DFS_Visit(int vertex){
		colors[vertex]='G';
		for(int i=0;i<adjList[vertex].size();i++){
			if(colors[i]=='W'){
				parent[i]=this.vertices[vertex];
				DFS_Visit(i);
				
			}
		colors[vertex]='B';
		System.out.println("Visited the vertex "+this.vertices[vertex] );
		}		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the vertices of the Graph");
		int V=sc.nextInt();
		Graph G=new Graph(V);
		G.addVertices(V);
		
			for(int vertex: G.vertices){
				G.createAdjacencyList(GraphMethods.createEdge(G.vertices));
			}
				
		G.printGraph();		
		//G.outDegree();
		System.out.println("Path between "+G.vertices[0]+" and "+G.vertices[1]+"? "+G.isPath(G.vertices[0],G.vertices[1]));
		G.depthFirstSearch();
	}
	
		
	

}
