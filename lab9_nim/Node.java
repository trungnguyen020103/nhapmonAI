package lab9_nim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
	    List<Node> successors = new ArrayList<>();

	    for (int i = 0; i < data.size(); i++) {
	        for (int j = 1; j < data.get(i); j++) {
	            Node successor = new Node();
	            List<Integer> newData = new ArrayList<>(data);
	            newData.set(i, j);
	            successor.addAll(newData);
	            successors.add(successor);
	        }
	    }

	    return successors;
	}


	// Check whether a node is terminal or not
	public boolean isTerminal() {
		Collections.sort(data, DESCOMPARATOR);
		Integer getDataOne = data.get(0);
				if (getDataOne<= 2) {
					return true;
				
		}
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}
	
	 }    


