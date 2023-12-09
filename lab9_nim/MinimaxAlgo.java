package lab9_nim;

import java.util.List;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		 if (node.isTerminal()) {
	            // Nếu node là terminal node, trả về giá trị tiện ích
	            return getUtility(node);
	        }

	        int v = Integer.MIN_VALUE;
	        List<Node> successors = node.getSuccessors();

	        for (Node successor : successors) {
	            v = Math.max(v, minValue(successor));
	        }

	        return v;
	}



	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		 if (node.isTerminal()) {
	            return getUtility(node);
	        }

	        int v = Integer.MAX_VALUE;
	        List<Node> successors = node.getSuccessors();

	        for (Node successor : successors) {
	            v = Math.min(v, maxValue(successor));
	        }
	        return v;
	}
	 public int getUtility(Node node) {
		 if(node.isTerminal()) {
			 return (node.getSuccessors().size()%2 ==1) ? 1:-1;
		 }else {
		return 0;
	 }
	 }
}
