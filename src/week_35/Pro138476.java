package src.week_35;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 프로그래머스 - 귤 고르기
 */
public class Pro138476 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Elem> pq = new PriorityQueue<>();

        for (int tangerineType : tangerine) {
            map.put(tangerineType, map.getOrDefault(tangerineType, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            pq.add(new Elem(key, map.get(key)));
        }

        int cmp = tangerine.length - k;
        while (true) {
            Elem cur = pq.peek();
            if (cmp >= cur.quantity) {
                cmp -= cur.quantity;
                pq.poll();
            } else {
                break;
            }
        }
        return pq.size();
    }

    private static class Elem implements Comparable<Elem> {
        int key;
        int quantity;

        public Elem(int key, int quantity) {
            this.key = key;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(Elem o) {
            return this.quantity - o.quantity;
        }
    }
}
