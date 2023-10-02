package graphApp;

import java.util.stream.IntStream;
import java.util.ArrayList ;
import java.util.Arrays;
import java.util.Comparator;

import dataStructures.Edge;
import dataStructures.Graph;
import dataStructures.GraphAdjList;
import dataStructures.GraphAdjMatrix;
import dataStructures.HeapNode;
import dataStructures.MinHeap;
import dataStructures.UnionFind;

public class GraphAlgo {
	
	public static void Dijkstra (Graph graph , int source) {
		if (graph instanceof GraphAdjList) Dijkstra((GraphAdjList)graph , source) ;
		else if (graph instanceof GraphAdjMatrix) Dijkstra((GraphAdjMatrix)graph , source) ;
	}
	
	/**
	 * Uses Minimizing Heap as Priority Queue
	 */
	private static void Dijkstra(GraphAdjList graph , int source) 
	{
		/* Initilisation */
		
		int numVertices = graph.getNumVertices() ;
		int numUnvisited = numVertices ;
		
		int[] shortestDist = new int[numVertices] ;		
		int[] prevVertices = new int[numVertices] ;
		boolean[] visited = new boolean[numVertices] ;
		
		for (int i = 0 ; i < numVertices ; i++) {
			shortestDist[i] = Integer.MAX_VALUE ;
			prevVertices[i] = -1 ;
			visited[i] = false ;			
		}
		shortestDist[source] = 0 ;
		
		int[] vertices = IntStream.range (0 , numVertices).toArray() ;
		MinHeap pq = new MinHeap (shortestDist , vertices) ;
		
		/* while priority queue pq is not empty */

		while (numUnvisited > 0) {
			
			HeapNode nearestNode = pq.popSmallest() ;
			
			// if the nearestNode is already visited
			if (visited[nearestNode.getValue()]) continue ;
			
			visited[nearestNode.getValue()] = true ;
			numUnvisited-- ;
			
			Edge[] adjEdges = graph.getAdjEdges(nearestNode.getValue()) ;
			
			for (int i = 0 ; i < adjEdges.length ; i++) {
				
				if (visited [adjEdges[i].getTerminal()]) continue ;
				
				int altDist = shortestDist[nearestNode.getValue()] + adjEdges[i].getWeight() ;
				
				if (altDist < shortestDist[adjEdges[i].getTerminal()]) {
					shortestDist[adjEdges[i].getTerminal()] = altDist ;
					prevVertices[adjEdges[i].getTerminal()] = nearestNode.getValue() ;
					pq.insert (altDist , adjEdges[i].getTerminal()) ;
				}
			}
		}
		
		/* print function */
		
		for (int i = 0 ; i < numVertices ; i++) {
			System.out.printf ("The shortest distance from vertex %d to vertex %d is %d\nFollowing path: " , source , i , shortestDist[i]) ;
			
			int vertex = i ;
			while (prevVertices[vertex] != -1){
				System.out.printf("%d - ", vertex) ;
				vertex = prevVertices[vertex] ;
			}
			System.out.print(source) ;
			System.out.print("\n\n");
		}
	}
	
	/**
	 * Uses Array as Priority Queue
	 */
	private static void Dijkstra(GraphAdjMatrix graph , int source) 
	{
		/* Initilisation */
		
		int numVertices = graph.getNumVertices() ;
		int numUnvisited = numVertices ;
		
		int[] shortestDist = new int[numVertices] ;		
		int[] prevVertices = new int[numVertices] ;
		boolean[] visited = new boolean[numVertices] ;
		
		for (int i = 0 ; i < numVertices ; i++) {
			shortestDist[i] = Integer.MAX_VALUE ;
			prevVertices[i] = -1 ;
			visited[i] = false ;			
		}
		shortestDist[source] = 0 ;
		
		/* while priority queue pq is not empty */

		while (numUnvisited > 0) {
			
			int nearestNode = -1 ;
			for (int i = 0 ; i < numVertices ; i++) {
				if (visited[i] == false && 
						( nearestNode == -1 || shortestDist[i] < shortestDist[nearestNode] )
					) nearestNode = i ;
			}
			
			visited[nearestNode]= true ;
			numUnvisited-- ;
			
			int[] adjEdges = graph.getAdjEdges(nearestNode) ;
			
			for (int terminalVertex = 0 ; terminalVertex < adjEdges.length ; terminalVertex++) {
				
				if (adjEdges[terminalVertex] == -1 || visited [terminalVertex]) continue ;
				
				int altDist = shortestDist[nearestNode] + adjEdges[terminalVertex] ;
				
				if (altDist < shortestDist[terminalVertex]) {
					shortestDist[terminalVertex] = altDist ;
					prevVertices[terminalVertex] = nearestNode ;
				}
			}
		}
		
		/* print function */
		
		for (int i = 0 ; i < numVertices ; i++) {
			System.out.printf ("The shortest distance from vertex %d to vertex %d is %d\nFollowing path: " , source , i , shortestDist[i]) ;
			
			int vertex = i ;
			while (prevVertices[vertex] != -1){
				System.out.printf("%d - ", vertex) ;
				vertex = prevVertices[vertex] ;
			}
			System.out.print(source) ;
			System.out.print("\n\n");
		}
	}

	public static void Prim (GraphAdjList graph) {
		
		/* Initilisation */
		
		int numVertices = graph.getNumVertices() ;
 		int numUnvisited = numVertices ;
 		
 		// given a vertex i
		int[] leastEdgeWeights = new int[numVertices] ; // edge with the least weight with i as end vertex
		int[] startVertices = new int[numVertices] ; // the start vertex of the least weight edge 
		boolean[] visited = new boolean[numVertices] ;
	
		for (int i = 0 ; i < numVertices ; i++) { 
			leastEdgeWeights[i] = Integer.MAX_VALUE ;
			startVertices[i] = -1 ;
			visited[i] = false ;
		}

		leastEdgeWeights[0] = 0 ;
		
		int[] vertices = IntStream.range (0 , numVertices).toArray() ;
		MinHeap pq = new MinHeap (leastEdgeWeights , vertices) ;
		
		/* while priority queue pq is not empty */
		
		while (numUnvisited > 0) {
			
			HeapNode nearestNode = pq.popSmallest() ;
			
			// if the nearestNode is already visited
			if (visited[nearestNode.getValue()]) continue ;
			
			visited[nearestNode.getValue()] = true ;
			numUnvisited-- ;
			
			Edge[] adjEdges = graph.getAdjEdges(nearestNode.getValue()) ;
			
			for (int i = 0 ; i < adjEdges.length ; i++) {
				if (visited[adjEdges[i].getTerminal()]) continue ;
				
				if (adjEdges[i].getWeight() < leastEdgeWeights[adjEdges[i].getTerminal()]) {
					leastEdgeWeights[adjEdges[i].getTerminal()] = adjEdges[i].getWeight() ;
					startVertices[adjEdges[i].getTerminal()] = nearestNode.getValue() ;
					pq.insert(adjEdges[i].getWeight() , adjEdges[i].getTerminal());
				}
			}
		}
		
		/* print function */
		
		int minWeight = 0 ;
		
		System.out.println("MST:") ;
		for (int i = 1 ; i < numVertices ; i++) {
			System.out.printf ("Edge: %d - %d , weight: %d\n" , startVertices[i] , i , leastEdgeWeights[i]) ;
			minWeight += leastEdgeWeights[i] ;
		}
		System.out.printf ("MST Weight: %d\n" , minWeight) ;
	}
	
	public static void Kruskal (GraphAdjList graph) {
		ArrayList<Edge> mst = new ArrayList<Edge>() ;
		UnionFind uf = new UnionFind(graph.getNumVertices()) ;
		Edge[] edges = graph.getAllEdges() ;
		
		Arrays.sort(edges , new Comparator<Edge>() {
			public int compare (Edge e1 , Edge e2) {
				return Integer.compare(e1.getWeight(), e2.getWeight()) ;
 			}
		});
		
		for (int i = 0 ; i < graph.getNumEdges() ; i++) {
			if (! uf.connected(edges[i].getInitial() , edges[i].getTerminal())) {
				uf.union(edges[i].getInitial() , edges[i].getTerminal());
				mst.add(edges[i]) ;
			}
		}
		
		int minWeight = 0 ;
		
		System.out.println("MST:") ;
		for (int i = 0 ; i < mst.size() ; i++) {
			System.out.printf ("Edge: %d - %d , weight: %d\n" , mst.get(i).getInitial() , mst.get(i).getTerminal() , mst.get(i).getWeight()) ;
			minWeight += mst.get(i).getWeight() ;
		}
		System.out.printf ("MST Weight: %d\n" , minWeight) ;
		
	}

	public static void buildGraph(Graph graph , int numEdges , int maxWeight) {
		
		int numVertices = graph.getNumVertices() ;
		
		if (numEdges < numVertices - 1) throw new RuntimeException ("numEdges lower than the min possible number of edges to build a connected graph with specified number of vertices") ;
		
		if (numEdges > numVertices * (numVertices - 1)) throw new RuntimeException ("numEdges exceed max possible number of edges for a graph with specified number of vertices") ;
		
		ArrayList<Integer> connectedTree = new ArrayList<Integer>() ;
		connectedTree.add(0) ;
		
		for (int v = 1 ; v < numVertices ; v++) {
			int terminalVertex = connectedTree.get ((int)(Math.random() * connectedTree.size())) ;
			connectedTree.add(terminalVertex) ;
			graph.addEdge(v , terminalVertex , (int)(Math.random() * (maxWeight + 1))) ;
		}
	
		for (int e = numVertices ; e < numEdges ; e++) {
			
			while (! graph.addEdge (
					(int)(Math.random() * numVertices) , 
					(int)(Math.random() * numVertices) , 
					(int)(Math.random() * (maxWeight + 1))
					)) ;
		}
		
	}
	
	
}
