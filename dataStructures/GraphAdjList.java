package dataStructures;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;

public class GraphAdjList implements Graph {
		
	protected HashMap<Integer, LinkedList<Edge>> adjList = new HashMap<Integer, LinkedList<Edge>>() ;
	protected int numVertices ;
	protected int numEdges ;
	
	
	/**
	 * Create a Adjacency List Graph object with the specified number of vertices.
	 * @param numVertices number of vertices in the graph.
	 */
	public GraphAdjList (int numVertices) {
		this.numVertices = numVertices ;
		
		for (int i = 0 ; i < numVertices ; i++) {
			adjList.put (i , new LinkedList<Edge>()) ;
		}
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
		
		for (int i = 0 ; i < adjList.get(edge.getInitial()).size() ; i++) {
			
			if (edge.getTerminal() < adjList.get(edge.getInitial()).get(i).getTerminal()) {
				
				adjList.get(edge.getInitial()).add(i, edge) ;
				numEdges++ ;
				return true ;
				
			} else if (edge.getTerminal() == adjList.get(edge.getInitial()).get(i).getTerminal()) {
				return false ;
			}
		}
		
		adjList.get(edge.getInitial()).add(edge) ;
		numEdges++ ;
		return true ;
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
	 * Delete an edge from the graph. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
	 * @param edge Edge object to be deleted
	 * @return True if edge is successfully deleted, false if edge does not exist / vertex out of range.
	 */
	public boolean deleteEdge (Edge edge) {
		
		if (! checkRange (edge)) return false ;
		
		for (int i = 0 ; i < adjList.get(edge.getInitial()).size() ; i++) {
			
			if (edge.getTerminal() == adjList.get(edge.getInitial()).get(i).getTerminal()) {
				
				adjList.get(edge.getInitial()).remove(i) ;
				numEdges-- ;
				return true ;
				
			} else if (edge.getTerminal() > adjList.get(edge.getInitial()).get(i).getTerminal()) {
				return false ;
			}
		}
		
		return false ;
	}

	/**
	 * Delete an edge from the graph, with the option to delete the reverse edge together as well. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
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
	 * Delete an edge from the graph. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
	 * @param initial initial vertex
	 * @param terminal terminal vertex
	 * @return True if edge is successfully deleted, false if edge does not exist / vertex out of range.
	 */
	public boolean deleteEdge (int initial , int terminal) {
		return deleteEdge (new Edge (initial , terminal , 0)) ;
	}
	
	
	/**
	 * Delete an edge from the graph, with the option to delete the reverse edge together as well. Edges with the same initial and terminal vertex will be treated as the same edge, even if the weight is different. If the graph has an edge with the matching initial an terminal vertex, it will be deleted, even if the weight might be different.
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
	 * @return Array of edges that has the specified vertex as the initial vertex.
	 */
	public Edge[] getAdjEdges (int vertex) {
		
		Object[] objArray = adjList.get(vertex).toArray() ;
		return Arrays.copyOf(objArray , objArray.length , Edge[].class);
	}
	
	
	/**
	 * @return array of all edges
	 */
	public Edge[] getAllEdges () {
		LinkedList<Edge> edges = new LinkedList<Edge>() ;
		for (int vertex = 0 ; vertex < numVertices ; vertex++) {
			edges.addAll(adjList.get(vertex)) ;
		}
		
		return Arrays.copyOf(edges.toArray() , edges.size() , Edge[].class);
	}
	
	
	public int getNumVertices() {
		return numVertices ;
	}
	
	
	public int getNumEdges() {
		return numEdges ;
	}
	
}
