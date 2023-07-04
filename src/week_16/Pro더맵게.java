package src.week_16;

import java.util.PriorityQueue;

/**
 * 프로그래머스 - 더 맵게
 */
public class Pro더맵게 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        int cnt = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            Integer first = pq.poll();
            Integer second = pq.poll();
            pq.add(first + second * 2);
            cnt++;
        }
        return pq.peek() >= K ? cnt : -1;
    }
}
