package src.week_16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 다리를 지나는 트럭
 */
public class Pro다리를지나는트럭 {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Truck> que = new LinkedList<>();

        int i = 0;
        int cnt = 0;
        while (true) {
            time++;
            if (!que.isEmpty() && (time - que.peek().rate == bridge_length)) {
                Truck truck = que.poll();
                weight += truck.weight;
                cnt--;
            }
            if (i < truck_weights.length && truck_weights[i] <= weight && cnt <= bridge_length) {
                que.add(new Truck(truck_weights[i], time));
                weight -= truck_weights[i];
                cnt++;
                i++;
            }
            if (que.isEmpty())
                break;
        }
        return time;
    }

    private static class Truck {
        int weight;
        int rate;

        public Truck(int weight, int rate) {
            this.weight = weight;
            this.rate = rate;
        }
    }
}
