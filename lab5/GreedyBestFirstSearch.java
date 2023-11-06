package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new PuzzleUtils().HeuristicComparatorByH);
		List<Node> explore = new ArrayList<Node>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
		Node current =frontier.poll();
			if(current.getH()==0) {
				return current;
			}else {
				List<Node> getChild = model.getSuccessors(current);
				for(Node child : getChild) {
					if(!frontier.contains(child)&&!explore.contains(child)) {
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}
	


}
