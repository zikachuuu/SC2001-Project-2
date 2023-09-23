package dataStructures;

public class UnionFind {
	
	protected int[] id ;
	protected int[] treeSizes ;
	protected int size ;
	
	public UnionFind (int size) {
		id = new int[size] ;
		treeSizes = new int[size] ;
		this.size = size ;
		
		for (int i = 0 ; i < size ; i++) {
			id[i] = i ;
			treeSizes[i] = 1 ;
		}
	}
	
	public int find (int i) {
		while (i != id[i]) {
			id[i] = id[id[i]] ;
			i = id[i] ;
		}
		return i ;
	}
	
	public boolean connected (int i , int j) {
		return find(i) == find(j) ;
	}
	
	public void union (int i , int j) {
		int iRoot = find(i) ;
		int jRoot = find(j) ;
		
		if (treeSizes[iRoot] < treeSizes[jRoot]) {
			id[iRoot] = jRoot ;
			treeSizes[jRoot] += treeSizes[iRoot] ;
		} else {
			id[jRoot] = iRoot ;
			treeSizes[iRoot] += treeSizes[jRoot] ;
		}
	}
}
