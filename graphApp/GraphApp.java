package graphApp;

import java.util.Scanner;

import dataStructures.Edge;
import dataStructures.Graph;
import dataStructures.GraphAdjList;
import dataStructures.GraphAdjMatrix; 

public class GraphApp {

	public static void main(String[] args) {		
		
		Scanner sc = new Scanner (System.in) ;
		// dummy object to turn off "local variable may not have been initialized" error
		Graph graph = new GraphAdjList(0) ;
		
		System.out.print ("1. Adjacency List Graph\n"
				+ "2. Adjacency Matrix Graph\n") ;
		System.out.print ("Choose an option: ") ;
		int graphType = sc.nextInt() ;
		System.out.println() ;
		
		System.out.print ("1. SC2001 Lec 6 pg 11 (Dijkstra)\n"
				+ "2. SC2001 Lec 6 pg 25 (Prim)\n"
				+ "3. SC2001 Lec 6 pg 28 (Prim)\n"
				+ "4. SC2001 Lec 7 pg 66 (Kruskal)\n"
				+ "5. SC2001 Tut 2 Qn 1 (Dijkstra)\n"
				+ "6. SC2001 Tut 2 Qn 4 (Prim)\n"
				+ "9. MH1301 Lec 11 pg 32 (Dijkstra)\n") ;
		System.out.print ("Choose an option: ") ;
		int graphEg = sc.nextInt() ;
		System.out.println() ;
		
		switch (graphEg) {
			case 1 :
				if (graphType == 1) graph = new GraphAdjList(5) ;
				else graph = new GraphAdjMatrix(5) ;		
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
				if (graphType == 1) graph = new GraphAdjList(4) ;
				else graph = new GraphAdjMatrix(4) ;		
				graph.addEdge(new Edge(0 , 1 , 2) , true) ;
				graph.addEdge(new Edge(0 , 2 , 3) , true) ;
				graph.addEdge(new Edge(0 , 3 , 2) , true) ;
				graph.addEdge(new Edge(1 , 3 , 1) , true) ;		
				graph.addEdge(new Edge(2 , 3 , 4) , true) ;
				break ;
			
			case 3 :
				if (graphType == 1) graph = new GraphAdjList(14) ;
				else graph = new GraphAdjMatrix(14) ;		
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
				if (graphType == 1) graph = new GraphAdjList(8) ;
				else graph = new GraphAdjMatrix(8) ;		
				graph.addEdge(0 , 7 , 16 , true) ;
				graph.addEdge(2 , 3 , 17 , true) ;
				graph.addEdge(1 , 7 , 19 , true) ;
				graph.addEdge(0 , 2 , 26 , true) ;
				graph.addEdge(5 , 7 , 28 , true) ;
				graph.addEdge(1 , 3 , 29 , true) ;
				graph.addEdge(1 , 5 , 32 , true) ;
				graph.addEdge(2 , 7 , 34 , true) ;
				graph.addEdge(4 , 5 , 35 , true) ;
				graph.addEdge(1 , 2 , 36 , true) ;
				graph.addEdge(4 , 7 , 37 , true) ;
				graph.addEdge(0 , 4 , 38 , true) ;
				graph.addEdge(6 , 2 , 40 , true) ;
				graph.addEdge(3 , 6 , 52 , true) ;
				graph.addEdge(6 , 0 , 58 , true) ;
				graph.addEdge(6 , 4 , 93 , true) ;
				break ;
			
			case 5 :
				if (graphType == 1) graph = new GraphAdjList(5) ;
				else graph = new GraphAdjMatrix(5) ;		
				graph.addEdge(new Edge (0 , 1 , 4)) ;
				graph.addEdge(new Edge (0 , 2 , 2)) ;
				graph.addEdge(new Edge (0 , 3 , 6)) ;
				graph.addEdge(new Edge (0 , 4 , 8)) ;
				graph.addEdge(new Edge (1 , 3 , 4)) ;
				graph.addEdge(new Edge (1 , 4 , 3)) ;
				graph.addEdge(new Edge (2 , 3 , 1)) ;
				graph.addEdge(new Edge (3 , 1 , 1)) ;
				graph.addEdge(new Edge (3 , 4 , 3)) ;
				break ;
			
			case 6 :
				if (graphType == 1) graph = new GraphAdjList(7) ;
				else graph = new GraphAdjMatrix(7) ;		
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
				if (graphType == 1) graph = new GraphAdjList(6) ;
				else graph = new GraphAdjMatrix(6) ;		
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
		System.out.println ("*** Graph created ***\n") ;
		 				
		
		System.out.print ("1. Dijkstra's Algorithm\n"
				+ "2. Prim's Algorithm\n"
				+ "3. Kruskal's Algorithm\n") ;
		System.out.print ("Choose an option: ") ;
		int algo = sc.nextInt() ;
		System.out.println() ;
		
		switch (algo) {
			case 1 :
				if (graphType == 1) GraphAlgo.Dijkstra((GraphAdjList)graph, 0) ;
				else GraphAlgo.Dijkstra((GraphAdjMatrix)graph, 0) ;	
				break ;
				
			case 2 :
				if (graphType == 1) GraphAlgo.Prim((GraphAdjList)graph) ;
				else ;
				break ;
			
			case 3 :
				if (graphType == 1) GraphAlgo.Kruskal((GraphAdjList)graph) ;
				else ;
				break ;
				
			default :
				break ;
		}
		
		sc.close();
	}

}
