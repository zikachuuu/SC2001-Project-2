package dataStructures;

public class Edge {
	
	protected int initialVertex ;
	protected int terminalVertex ;
	protected int weight ;
	
	/**
	 * @param startVertex
	 * @param endVertex
	 * @param weight
	 */
	public Edge (int startVertex , int endVertex , int weight) {
		this.initialVertex = startVertex ;
		this.terminalVertex = endVertex ;
		this.weight = weight ;
	}
	
	// return a new edge with reversed direction but same weight
	public Edge getReverse() {
		return new Edge (terminalVertex , initialVertex , weight) ;
	}
	
	public int getInitial() {
		return initialVertex ;
	}
	
	public int getTerminal() {
		return terminalVertex ;
	}
	
	public int getWeight() {
		return weight ;
	}
	
}
