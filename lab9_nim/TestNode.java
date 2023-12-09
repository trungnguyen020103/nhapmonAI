package lab9_nim;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		        testMinimaxWithInitialConfiguration(new Integer[]{3, 5, 7, 2});  
		        testMinimaxWithInitialConfiguration(new Integer[]{1, 4, 6, 8});  	
		    }

		    private static void testMinimaxWithInitialConfiguration(Integer[] initialConfiguration) {
		        Node node = new Node();
		        node.addAll(Arrays.asList(initialConfiguration));

		        MinimaxAlgo algo = new MinimaxAlgo();
		        System.out.println("Cau hinh ban dau: " + node);
		        int optimalValue = algo.maxValue(node);
		        System.out.println("Gia tri toi uu: " + optimalValue);
		        System.out.println("-------------------------");
		    }
}