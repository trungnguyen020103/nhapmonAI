package lab8_AlphaBetaSearch;

public interface ISearchAlgo {
	public void execute(Node node);
	public static void main(String[] args) {
        // Tạo cây trò chơi
        Node root = createGameTree();

        // Sử dụng thuật toán MiniMax
        ISearchAlgo minimaxAlgo = new MiniMaxSearchAlgo();
        System.out.println("Minimax Algorithm:");
        minimaxAlgo.execute(root);

        // Sử dụng thuật toán Alpha-Beta Pruning
        ISearchAlgo alphaBetaAlgo = new AlphaBetaSearchAlgo();
        System.out.println("Alpha-Beta Algorithm:");
        alphaBetaAlgo.execute(root);
        
    }

    private static Node createGameTree() {
        Node root = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");
        Node nodeK = new Node("K");
        Node nodeL = new Node("L");
        Node nodeM = new Node("M");
        Node nodeN = new Node("N"); 
        Node nodeO = new Node("O");
        Node nodeP = new Node("P");
        Node nodeQ = new Node("Q");
        Node nodeR = new Node("R");
        Node nodeS = new Node("S");
        Node nodeT = new Node("T");
        Node nodeU = new Node("U");
        Node nodeV = new Node("V");
        Node nodeW = new Node("W");
        Node nodeX = new Node("X");
        root.addChild(nodeB);
        root.addChild(nodeC);
        root.addChild(nodeD);
        root.addChild(nodeE);
        nodeB.addChild(nodeF);
        nodeB.addChild(nodeG);

        nodeC.addChild(nodeI);
        nodeC.addChild(nodeJ);
        nodeE.addChild(nodeK);
        nodeE.addChild(nodeL);
        nodeE.addChild(nodeM);
        nodeF.addChild(nodeN);
        nodeF.addChild(nodeO);
        nodeO.addChild(nodeW);
        nodeO.addChild(nodeX);
        nodeJ.addChild(nodeP);
        nodeJ.addChild(nodeQ);
        nodeJ.addChild(nodeR);
        nodeK.addChild(nodeS);
        nodeK.addChild(nodeT);
        nodeM.addChild(nodeU);
        nodeM.addChild(nodeV);
        // Thiết lập giá trị cho các nút lá
	    nodeD.setValue(0);
	    nodeG.setValue(-5);
	    nodeH.setValue(3);
	    nodeI.setValue(8);
	    nodeL.setValue(2);
	    nodeN.setValue(4);
	    nodeP.setValue(9);
	    nodeQ.setValue(-6);
	    nodeR.setValue(-0);
	    nodeS.setValue(3);
	    nodeT.setValue(5);
	    nodeU.setValue(-7);
	    nodeV.setValue(-9);
	    nodeW.setValue(-3);
	    nodeX.setValue(-5);
        return root;
    }
}
