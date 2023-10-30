package lab4;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
	List<Node> explore = new ArrayList<Node>();

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel().equals(goal)) {
			return root;
		}
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal)) {
				return currentNode;
			}
			explore.add(currentNode);
			List<Node> nodeChild = currentNode.getChildrenNodes();
			for (Node child : nodeChild) {
				if (!frontier.contains(child) && !explore.contains(child)) {
					frontier.add(child);
					child.setParent(currentNode);
				}
			}

		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root.getLabel().equals(goal)) {
			return root;
		}
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if(currentNode.getLabel().equals(goal)&&explore.contains(new Node(start))) {
				return currentNode;
			}
			if(currentNode.getLabel().equals(start)) {
				frontier.clear();
				currentNode.setParent(null);
			}
			List<Node> nodeChild = currentNode.getChildrenNodes();
			for (Node child : nodeChild) {
				if (!frontier.contains(child) && !explore.contains(child)) {
					frontier.add(child);
					child.setParent(currentNode);
				}
		}

	}
		return null;

}
}
