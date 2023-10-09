package k21;

import task1_2.ISearchAlgo;
import task1_2.Node;
import task1_2.NodeUtils;
import task3.DepthFirstSearchTreeSearch;

public class TestDrive {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
//		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
//		Node result = algo1.execute(nodeS, "G");
//		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
//		Node result = algo2.execute(nodeS,"A","H");
		ISearchAlgo algo = new DepthFirstSearchTreeSearch();
		Node result = algo.execute(nodeS, "C", "G");
		System.out.println(NodeUtils.printPath(result));
	}
}
