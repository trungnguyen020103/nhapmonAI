package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		  initPopulation(); 

		    int iteration = 0;
		    while (iteration < MAX_ITERATIONS) {
		        List<Node> newPopulation = new ArrayList<>();

		 
		        for (int i = 0; i < POP_SIZE; i++) {
		
		            Node parent1 = getParentByTournamentSelection();
		            Node parent2 = getParentByTournamentSelection();

	
		            Node child = reproduce(parent1, parent2);

	
		            if (Math.random() < MUTATION_RATE) {
		                mutate(child);
		            }
		            newPopulation.add(child);
		        }
		        population = newPopulation;
		        for (Node individual : population) {
		            if (individual.getFitness() == 0) {
		                return individual; 
		            }
		        }

		        iteration++;
		    }

		    Node bestIndividual = population.get(0);
		    for (Node individual : population) {
		        if (individual.getFitness() < bestIndividual.getFitness()) {
		            bestIndividual = individual;
		        }
		    }

		    return bestIndividual;
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		int randomQueen = rd.nextInt(node.N); // Assuming getSize() returns the size of the board
	    int newRow = rd.nextInt(node.N);
	    node.getQueen(randomQueen).setRow(newRow);
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
			Queen[] parent1 = x.getState();
		    Queen[] parent2 = y.getState();
		    
		    int boardSize = x.N; 
		    Queen[] childState = new Queen[boardSize];

		    int crossoverPoint = rd.nextInt(boardSize);

		    for (int i = 0; i < crossoverPoint; i++) {
		        childState[i] = new Queen(parent1[i].getRow(), parent1[i].getColumn());
		    }

		    for (int i = crossoverPoint; i < boardSize; i++) {
		        childState[i] = new Queen(parent2[i].getRow(), parent2[i].getColumn());
		    }

		    Node child = new Node();
		    child.setState(childState);

		    return child;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		 int tournamentSize = 5; 
	        Node best = null;
	        for (int i = 0; i < tournamentSize; i++) {
	            Node candidate = population.get(rd.nextInt(POP_SIZE));
	            if (best == null || candidate.getFitness()> best.getFitness()) {
	                best = candidate;
	            }
	        }
	        return best;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		  return population.get(rd.nextInt(POP_SIZE));
	}
	
	 }
