package graphAdjMatrix;

import java.util.Scanner;

import graphAdjList.Edge;

public class GraphApp2 {
	public static void main(String[] args) {				
		
		Scanner sc = new Scanner (System.in) ;
		GraphAdjMatrix graph = new GraphAdjMatrix(0) ;
		
		System.out.print ("Using AdjMatrix...\n"
				+ "1. SC2001 Lec 6 pg 11 (Dijkstra)\n"
				+ "2. SC2001 Lec 6 pg 25 (Prim)\n"
				+ "3. SC2001 Lec 6 pg 28 (Prim)\n"
				+ "4. SC2001 Tut 2 Qn 1 (Dijkstra)\n"
				+ "5. SC2001 Tut 2 Qn 4 (Prim)\n"
				+ "9. MH1301 Lec 11 pg 32 (Dijkstra)\n") ;
		
		System.out.print ("Choose an option: ") ;
		int choice = sc.nextInt() ;
		
		switch (choice) {
			case 1 :
				graph = new GraphAdjMatrix(5) ;
				graph.addEdge(0 , 1 , 5) ;
				graph.addEdge(0 , 2 , 10) ;
				graph.addEdge(1 , 2 , 3) ;
				graph.addEdge(1 , 3 , 9) ;		
				graph.addEdge(1 , 4 , 2) ;
				graph.addEdge(2 , 1 , 2) ;
				graph.addEdge(2 , 3 , 1) ;
				graph.addEdge(3 , 1 , 2) ;		
				graph.addEdge(3 , 4 , 4) ;
				graph.addEdge(4 , 3 , 6) ;
				break ;
			
			case 2 :
				graph = new GraphAdjMatrix(4) ;
				graph.addEdge(new Edge(0 , 1 , 2) , true) ;
				graph.addEdge(new Edge(0 , 2 , 3) , true) ;
				graph.addEdge(new Edge(0 , 3 , 2) , true) ;
				graph.addEdge(new Edge(1 , 3 , 1) , true) ;		
				graph.addEdge(new Edge(2 , 3 , 4) , true) ;
				break ;
			
			case 3 :
				graph = new GraphAdjMatrix (14) ;
				graph.addEdge(0 , 1 , 8 , true) ;
				graph.addEdge(0 , 2 , 4 , true) ;
				graph.addEdge(0 , 3 , 2 , true) ;
				graph.addEdge(1 , 4 , 9 , true) ;
				graph.addEdge(1 , 12 , 5 , true) ;
				graph.addEdge(2 , 5 , 9 , true) ;
				graph.addEdge(3 , 4 , 8 , true) ;
				graph.addEdge(3 , 7 , 1 , true) ;
				graph.addEdge(4 , 6 , 2 , true) ;
				graph.addEdge(5 , 7 , 2 , true) ;
				graph.addEdge(5 , 8 , 5 , true) ;
				graph.addEdge(5 , 10 , 5 , true) ;
				graph.addEdge(6 , 7 , 8 , true) ;
				graph.addEdge(6 , 9 , 7 , true) ;
				graph.addEdge(7 , 8 , 2 , true) ;
				graph.addEdge(7 , 11 , 9 , true) ;
				graph.addEdge(8 , 11 , 9 , true) ;
				graph.addEdge(8 , 9 , 5 , true) ;
				graph.addEdge(9 , 13 , 5 , true) ;
				break ;
				
			case 4 :
				graph = new GraphAdjMatrix(5) ;
				graph.addEdge (new Edge (0 , 1 , 4)) ;
				graph.addEdge (new Edge (0 , 2 , 2)) ;
				graph.addEdge (new Edge (0 , 3 , 6)) ;
				graph.addEdge (new Edge (0 , 4 , 8)) ;
				graph.addEdge (new Edge (1 , 3 , 4)) ;
				graph.addEdge (new Edge (1 , 4 , 3)) ;
				graph.addEdge (new Edge (2 , 3 , 1)) ;
				graph.addEdge (new Edge (3 , 1 , 1)) ;
				graph.addEdge (new Edge (3 , 4 , 3)) ;
				break ;
			
			case 5 :
				graph = new GraphAdjMatrix(7) ;
				graph.addEdge(0 , 1 , 2 , true) ;
				graph.addEdge(0 , 5 , 7 , true) ;
				graph.addEdge(0 , 6 , 3 , true) ;
				graph.addEdge(1 , 2 , 4 , true) ;
				graph.addEdge(1 , 6 , 6 , true) ;
				graph.addEdge(2 , 4 , 2 , true) ;
				graph.addEdge(3 , 4 , 2 , true) ;
				graph.addEdge(3 , 5 , 5 , true) ;
				graph.addEdge(3 , 6 , 1 , true) ;
				graph.addEdge(4 , 6 , 3 , true) ;
				break ;


			
			case 9 :
				graph = new GraphAdjMatrix(6) ;
				graph.addEdge(0 , 1 , 4 , true) ;
				graph.addEdge(0 , 2 , 2 , true) ;
				graph.addEdge(1 , 2 , 1 , true) ;
				graph.addEdge(1 , 3 , 5 , true) ;		
				graph.addEdge(2 , 3 , 8 , true) ;
				graph.addEdge(2 , 4 , 10 , true) ;
				graph.addEdge(3 , 4 , 2 , true) ;
				graph.addEdge(3 , 5 , 6 , true) ;
				graph.addEdge(4 , 5 , 3 , true) ;
				break ;
				
			default :
				System.exit(0);
		}
		System.out.println ("Graph created\n") ;
		 				
		
		System.out.println ("1. Dijkstra's Algorithm") ;
		System.out.print ("Choose an option: ") ;
		choice = sc.nextInt() ;
		
		switch (choice) {
			case 1 :
				GraphAlgo2.Dijkstra(graph, 0) ;
				break ;
			default :
				break ;
		}
		
		sc.close();
	}

}
