package src.week_15;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프로그래머스 - 점프와 순간 이동
 */
public class Pro점프와순간이동 {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int cnt = 0;
        PriorityQueue<Elem> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        pq.add(new Elem(0, 0));

        while (!pq.isEmpty()) {
            Elem cur = pq.poll();

            if (cur.location == n) {
                cnt = cur.cnt;
                break;
            }

            int n_cnt = cur.cnt;
            int n_location = cur.location * 2;
            if (n_location <= n) {
                pq.add(new Elem(n_cnt, n_location));
            }

            n_cnt = cur.cnt + 1;
            n_location = cur.location + 1;
            if (n_location <= n) {
                pq.add(new Elem(n_cnt, n_location));
            }
        }

        return cnt;
    }

    private static class Elem {
        int cnt;
        int location;

        public Elem(int cnt, int location) {
            this.cnt = cnt;
            this.location = location;
        }
    }
}
