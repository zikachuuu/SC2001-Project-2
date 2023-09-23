package dataStructures;

public class HeapNode implements Comparable<HeapNode> {
	 protected int key ;
	 protected int value ;
	 
	 public HeapNode (int key , int value) {
		 this.key = key ;
		 this.value = value ;
	 }

	@Override
	public int compareTo(HeapNode other) {
		return Integer.compare(this.key, other.key);
	}
	
	public int getKey () {
		return this.key ;
	}
	
	public int getValue() {
		return this.value ;
	}
}
