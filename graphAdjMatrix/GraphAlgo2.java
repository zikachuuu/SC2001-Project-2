package graphAdjMatrix;

import java.util.stream.IntStream;

import graphAdjList.HeapNode;
import graphAdjList.MinHeap;

public class GraphAlgo2 {
	public static void Dijkstra(GraphAdjMatrix graph , int source) 
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
			
			visited[nearestNode.getValue()]= true ;
			numUnvisited-- ;
			
			int[] adjEdges = graph.getAdjEdges(nearestNode.getValue()) ;
			
			for (int terminalVertex = 0 ; terminalVertex < adjEdges.length ; terminalVertex++) {
				
				if (adjEdges[terminalVertex] == -1 || visited [terminalVertex]) continue ;
				
				int altDist = shortestDist[nearestNode.getValue()] + adjEdges[terminalVertex] ;
				
				if (altDist < shortestDist[terminalVertex]) {
					shortestDist[terminalVertex] = altDist ;
					prevVertices[terminalVertex] = nearestNode.getValue() ;
					pq.insert (altDist , terminalVertex) ;
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

}
