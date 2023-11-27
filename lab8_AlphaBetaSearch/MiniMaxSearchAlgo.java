package lab8_AlphaBetaSearch;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	public void execute(Node node) {
        int maxUtility = Integer.MIN_VALUE;
        Node maxNode = null;

        // Duyệt qua các nút con của nút hiện tại
        for (Node child : node.getChildren()) {
            int utility = minValue(child);
            if (utility > maxUtility) {
                maxUtility = utility;
                maxNode = child;
            }
        }

        // Thực hiện hành động tương ứng với nút có giá trị tối đa
        if (maxNode != null) {
            System.out.println("Perform action for node: " + maxNode.getLabel());
        }
    }


	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v

    private int maxValue(Node node) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int maxUtility = Integer.MIN_VALUE;

        // Duyệt qua các nút con của nút hiện tại
        for (Node child : node.getChildren()) {
            int utility = minValue(child);
            maxUtility = Math.max(maxUtility, utility);
        }

        return maxUtility;
    }
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v


    private int minValue(Node node) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int minUtility = Integer.MAX_VALUE;

        // Duyệt qua các nút con của nút hiện tại
        for (Node child : node.getChildren()) {
            int utility = maxValue(child);
            minUtility = Math.min(minUtility, utility);
        }

        return minUtility;
    }
	
}
