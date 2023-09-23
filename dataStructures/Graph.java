package dataStructures;

public interface Graph {
	
	public boolean addEdge (Edge edge) ;
	public boolean addEdge(Edge edge , boolean biDirectional) ;
	public boolean addEdge (int initial , int terminal , int weight) ;
	public boolean addEdge (int initial , int terminal , int weight , boolean biDirectional) ;
	
	public boolean deleteEdge (Edge edge) ;
	public boolean deleteEdge (Edge edge , boolean biDirectional) ;
	public boolean deleteEdge (int initial , int terminal) ;
	public boolean deleteEdge (int initial , int terminal , boolean biDirectional) ;
	
	public int getNumVertices() ;
	public int getNumEdges() ;
}
