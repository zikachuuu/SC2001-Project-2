package graphAdjList;

import java.util.stream.IntStream;

public class GraphAlgo {
	
	public static void Dijkstra(GraphAdjList graph , int source) 
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
			if (visited[nearestNode.value]) continue ;
			
			visited[nearestNode.value] = true ;
			numUnvisited-- ;
			
			Edge[] adjEdges = graph.getAdjEdges(nearestNode.value) ;
			
			for (int i = 0 ; i < adjEdges.length ; i++) {
				
				if (visited [adjEdges[i].terminalVertex]) continue ;
				
				int altDist = shortestDist[nearestNode.value] + adjEdges[i].weight ;
				
				if (altDist < shortestDist[adjEdges[i].terminalVertex]) {
					shortestDist[adjEdges[i].terminalVertex] = altDist ;
					prevVertices[adjEdges[i].terminalVertex] = nearestNode.value ;
					pq.insert (altDist , adjEdges[i].terminalVertex) ;
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
			if (visited[nearestNode.value]) continue ;
			
			visited[nearestNode.value] = true ;
			numUnvisited-- ;
			
			Edge[] adjEdges = graph.getAdjEdges(nearestNode.value) ;
			
			for (int i = 0 ; i < adjEdges.length ; i++) {
				if (visited[adjEdges[i].terminalVertex]) continue ;
				
				if (adjEdges[i].weight < leastEdgeWeights[adjEdges[i].terminalVertex]) {
					leastEdgeWeights[adjEdges[i].terminalVertex] = adjEdges[i].weight ;
					startVertices[adjEdges[i].terminalVertex] = nearestNode.value ;
					pq.insert(adjEdges[i].weight , adjEdges[i].terminalVertex);
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
	
}
