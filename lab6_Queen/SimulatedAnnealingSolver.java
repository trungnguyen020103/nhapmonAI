package lab6_Queen;

import java.util.List;
import java.util.Random;

public class SimulatedAnnealingSolver {
    private static final double INITIAL_TEMPERATURE = 1000.0;
    private static final double COOLING_RATE = 0.003;

    public static void main(String[] args) {
        Node initialState = new Node();
        Node finalState = simulatedAnnealing(initialState);

        System.out.println("Final State:");
        finalState.displayBoard();
    }

    public static Node simulatedAnnealing(Node initialState) {
        Node current = new Node(initialState);
        double temperature = INITIAL_TEMPERATURE;

        while (temperature > 1) {
            Node next = selectNextRandomCandidate(current);
            int currentH = current.getH();
            int nextH = next.getH();

            if (acceptanceProbability(currentH, nextH, temperature) > Math.random()) {
                current = next; // Chấp nhận trạng thái mới
            }

            temperature *= 1 - COOLING_RATE; // Giảm nhiệt độ theo tỷ lệ
        }

        return current;
    }

    // Phương thức chọn một trạng thái kế tiếp ngẫu nhiên
    public static Node selectNextRandomCandidate(Node currentState) {
        List<Node> candidates = currentState.generateAllCandidates();
        if (candidates.isEmpty()) {
            return null; // Không có trạng thái kế tiếp nào
        }

        Random random = new Random();
        int randomIndex = random.nextInt(candidates.size());
        return candidates.get(randomIndex);
    }

    // Phương thức tính xác suất chấp nhận trạng thái mới
    public static double acceptanceProbability(int currentH, int nextH, double temperature) {
        // Nếu trạng thái mới tốt hơn, chấp nhận nó ngay lập tức
        if (nextH < currentH) {
            return 1.0;
        }

        // Nếu trạng thái mới xấu hơn, tính xác suất chấp nhận dựa trên nhiệt độ
        return Math.exp((currentH - nextH) / temperature);
    }
}
