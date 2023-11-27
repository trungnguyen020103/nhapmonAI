package lab8_AlphaBetaSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	
	@Override
	public void execute(Node node) {
		 // Kiểm tra nếu nút là nút gốc
        if (node.isTerminal()) {
            // Nếu là nút lá, không có hành động cần thực hiện
            return;
        }
        int maxUtility = Integer.MIN_VALUE;
        Node maxNode = null;
        // Duyệt qua các nút con của nút hiện tại
        for (Node child : node.getChildren()) {
            int utility = minValue(child, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (utility > maxUtility) {
                maxUtility = utility;
                maxNode = child;
            }
        }

      
        System.out.println("Perform action for node: " + maxNode.getLabel());
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
	        return node.getValue();
	    }

	    int maxUtility = Integer.MIN_VALUE;

	    // Duyệt qua các nút con của nút hiện tại
	    for (Node child : node.getChildren()) {
	    	//
	        int utility = minValue(child, alpha, beta);
	        maxUtility = Math.max(maxUtility, utility);
	        alpha = Math.max(alpha, maxUtility);
	        if (maxUtility >= beta) {
	            break;
	        }
	    }

	    return maxUtility;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
	    if (node.isTerminal()) {
	        return node.getValue();
	    }

	    int minUtility = Integer.MAX_VALUE;

	    // Duyệt qua các nút con của nút hiện tại
	    for (Node child : node.getChildren()) {
	        int utility = maxValue(child, alpha, beta);
	        minUtility = Math.min(minUtility, utility);
	        beta = Math.min(beta, minUtility);
	        if (minUtility <= alpha) {
	            break;
	        }
	    }

	    return minUtility;
	
	}
	
	}

