package dataStructures;

import java.util.ArrayList ;

public class MinHeap {
	
	protected ArrayList<HeapNode> heap ;
	
	public MinHeap() {
		heap = new ArrayList<HeapNode>() ;
	}
	
	public MinHeap (int[] keys , int[] values) {
		this() ;
		
		for (int i = 0 ; i < keys.length ; i++) {
			heap.add (new HeapNode (keys[i] , values[i])) ;
		}
		heapify (0) ;
	}
	
	public void heapify (int parentNode)
	{
		// if parentNode is a leaf node
		if (2 * parentNode + 1 >= heap.size()) return ;
		
		int leftChild = 2 * parentNode + 1 ;
		int rightChild = 2 * parentNode + 2 ;
				
		heapify (leftChild) ;
		heapify (rightChild) ;
		
		fixHeap (parentNode) ;
	}
	
	private void fixHeap (int parentNode)
	{
		// if parentNode is a leaf node
		if (2 * parentNode + 1 >= heap.size()) return ;
		
		int leftChild = 2 * parentNode + 1 ;		
		int rightChild = 2 * parentNode + 2 ;
		
		int smallerChild ;
		if (rightChild < heap.size()) {
			smallerChild = heap.get(leftChild).key < heap.get(rightChild).key ? leftChild : rightChild ;
		} else {
			smallerChild = leftChild ;
		}
		
		if (heap.get(parentNode).key <= heap.get(smallerChild).key) {
			return ;
		} else {
			HeapNode temp = heap.get(parentNode) ;
			heap.set(parentNode , heap.get(smallerChild)) ;
			heap.set(smallerChild, temp) ;
			
			fixHeap (smallerChild) ;
		}
	}

	public boolean isEmpty() {
		return heap.size() == 0 ;
	}
	
	public HeapNode getSmallest() {
		if (isEmpty()) return null ;
		return heap.get(0) ;
	}
	
	public HeapNode popSmallest() {
		if (isEmpty()) return null ;
		
		HeapNode smallest = getSmallest() ;
		
		heap.set (0 , heap.get(heap.size() - 1)) ;
		heap.remove(heap.size() - 1) ;
		fixHeap(0) ;
		
		return smallest ;
	}

	public HeapNode pop (int index) {
		if (isEmpty()) return null ;
		
		HeapNode popped = heap.get(0) ;
		
		heap.set (index , heap.get(heap.size() - 1)) ;
		heap.remove(heap.size() - 1) ;
		fixHeap(index) ;
		
		return popped ;
	}
	
	public void insert(int key , int value) {
		
		heap.add (new HeapNode (key , value)) ;
		heapify(0) ;
	}

	public void printHeap() {				
		for (int i = 0 ; i < heap.size() ; i++) {
			System.out.printf("key: %d, value: %d\n" , heap.get(i).key , heap.get(i).value);
		}
	}
}
