package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < state.length; i++) {
			for (int j = i + 1; j < state.length; j++) {
				if (state[i].isConflict(state[j])) {
					heuristic++;
				}
			}

		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int currentColumn = 0; currentColumn < state.length; currentColumn++) {
			for (int newRow = 0; newRow < state.length; newRow++) {
				Node candidates = new Node();

				// di chuyen den hang khac', giu nguyen cot
				candidates.state[currentColumn].move();
				// them vao list
				result.add(candidates);
			}
		}

		return result;
	}

	// lay node ngau nhien
	public Node selectNextRandomCandidate(List<Node> candidates) {
		if (candidates.isEmpty()) {
			return null; // neu ko co node nao trong list
		}
		Random random = new Random();
		int randomIndex = random.nextInt(candidates.size());
		return candidates.get(randomIndex);
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}

	  public int getFitness() {
	        int fitness = 0;
	        for (int i = 0; i < N; i++) {
	            for (int j = i + 1; j < N; j++) {
	                // Check horizontal and diagonal attacks
	                if (state[i].isConflict(state[j]) || state[i].getRow() == state[j].getRow()) {
	                    fitness++;
	                }
	            }
	        }
	        return fitness;
	    }
	  public Queen getQueen(int index) {
		    return state[index];
		}

	public Queen[] getState() {
		// TODO Auto-generated method stub
		return state;
	}

	public void setState(Queen[] childState) {
	    this.state = Arrays.copyOf(childState, childState.length);
	}

}
