package dataStructures;

import java.util.Arrays;

public class GraphAdjMatrix implements Graph{
	protected int[][] adjMatrix ;
	protected int numVertices ;
	protected int numEdges ;
	
	
	/**
	 * Create a Adjacency Matrix Graph object with the specified number of vertices. Weights are default to -1.
	 * @param numVertices number of vertices in the graph.
	 */
	public GraphAdjMatrix (int numVertices) {
		this.numVertices = numVertices ;
		adjMatrix = new int[numVertices][numVertices] ;
		for (int i = 0 ; i < numVertices ; i++) Arrays.fill(adjMatrix[i] , -1);
	}
	
	
	/**
	 * ensure both the initial and terminal vertices exist in the graph
	 * @param edge edge to be checked
	 * @return true if vertices in edge exist, false otherwise
	 */
	private boolean checkRange(Edge edge) {
		if (edge.getInitial() < 0 || edge.getInitial() >= numVertices || edge.getTerminal() < 0 || edge.getTerminal() >= numVertices) {
			return false ;
		}
		return true ;
	}
	
	
	/**
	 * Add an weighted edge to the graph. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph already has a same edge, this method will return false and does not replace the original edge, even if the weight might be different.
	 * @param edge Edge object to be added to the graph.
	 * @return True if edge is successfully added, false if edge already inside / vertex out of range.
	 */
	public boolean addEdge (Edge edge) {
		
		if (! checkRange (edge)) return false ;
		
		if (adjMatrix[edge.getInitial()][edge.getTerminal()] == -1) {
			adjMatrix[edge.getInitial()][edge.getTerminal()] = edge.getWeight() ;
			numEdges++ ;
			return true ;
		}
		
		return false ;
	}
	
	
	/**
	 * Add an weighted edge to the graph, with the option to add the reverse edge together as well. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph already has a same edge, this method will return false and does not replace the original edge, even if the weight might be different.
	 * @param edge Edge object to be added to the graph.
	 * @param biDirectional True if you want to add the reverse edge into the graph as well, for example if the graph is undirected.
	 * @return True if at least one of the edges is successfully added, false if both edges cannot be added (edges already inside / vertex out of range).
	 */
	public boolean addEdge(Edge edge , boolean biDirectional) {
		
		boolean firstEdge = addEdge (edge) ;
		boolean secondEdge = false ;
		if (biDirectional) {
			secondEdge = addEdge (edge.getReverse()) ;
		}
		
		return firstEdge || secondEdge ;
	}
		
	
	/**
	 * Add an weighted edge to the graph. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph already has a same edge, this method will return false and does not replace the original edge, even if the weight might be different.
	 * @param initial initial vertex
	 * @param terminal terminal vertex
	 * @param weight weight of edge
	 * @return True if edge is successfully added, false if edge already inside / vertex out of range.
	 */
	public boolean addEdge (int initial , int terminal , int weight) {
		return addEdge (new Edge (initial , terminal , weight)) ;
	}
	
	
	/**
	 * Add an weighted edge to the graph, with the option to add the reverse edge together as well. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph already has a same edge, this method will return false and does not replace the original edge, even if the weight might be different.
	 * @param initial initial vertex
	 * @param terminal terminal vertex
	 * @param weight weight of edge
	 * @param biDirectional True if you want to add the reverse edge into the graph as well, for example if the graph is undirected.
	 * @return True if at least one of the edges is successfully added, false if both edges cannot be added (edges already inside / vertex out of range).
	 */
	public boolean addEdge (int initial , int terminal , int weight , boolean biDirectional) {
		return addEdge (new Edge (initial , terminal , weight) , biDirectional) ;
	}
	
	
	/**
	 * Delete an edge from the graph, resetting its weight to -1. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
	 * @param edge Edge object to be deleted
	 * @return True if edge is successfully deleted, false if edge does not exist / vertex out of range.
	 */
	public boolean deleteEdge (Edge edge) {
		
		if (! checkRange (edge)) return false ;
		
		if (adjMatrix[edge.getInitial()][edge.getTerminal()] != -1) {
			adjMatrix[edge.getInitial()][edge.getTerminal()] = -1 ;
			numEdges-- ;
			return true ;
		}
		return false ;
	}

	/**
	 * Delete an edge from the graph, resetting its weight to -1, with the option to delete the reverse edge together as well. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
	 * @param edge Edge object to be deleted
	 * @param biDirectional True if you want to delete the reverse edge from the graph as well, for example if the graph is undirected.
	 * @return True if at least one of the edges is successfully deleted, false if both edges cannot be deleted (edges do not exist / vertex out of range).
	 */
	public boolean deleteEdge (Edge edge , boolean biDirectional) {
		
		boolean firstEdge = deleteEdge (edge) ;
		boolean secondEdge = false ;
		if (biDirectional) {
			secondEdge = deleteEdge (edge.getReverse()) ;
		}
		
		return firstEdge || secondEdge ;
	}
	
	
	/**
	 * Delete an edge from the graph, resetting its weight to -1. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
	 * @param initial initial vertex
	 * @param terminal terminal vertex
	 * @return True if edge is successfully deleted, false if edge does not exist / vertex out of range.
	 */
	public boolean deleteEdge (int initial , int terminal) {
		return deleteEdge (new Edge (initial , terminal , 0)) ;
	}
	
	
	/**
	 * Delete an edge from the graph, resetting its weight to -1, with the option to delete the reverse edge together as well. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
	 * @param initial initial vertex
	 * @param terminal terminal vertex
	 * @param biDirectional True if you want to delete the reverse edge from the graph as well, for example if the graph is undirected.
	 * @return True if at least one of the edges is successfully deleted, false if both edges cannot be deleted (edges do not exist / vertex out of range).
	 */
	public boolean deleteEdge (int initial , int terminal , boolean biDirectional) {
		return deleteEdge (new Edge (initial , terminal , 0) , biDirectional) ;
	}
	
		
	/**
	 * @param vertex initial vertex
	 * @return an array which is the row of the adjacency matrix that corresponds to the specified vertex
	 */
	public int[] getAdjEdges(int vertex) {
		return adjMatrix[vertex] ;
	}
	
	
	public int getNumVertices() {
		return numVertices ;
	}
	
	
	public int getNumEdges() {
		return numEdges ;
	}
	

}
