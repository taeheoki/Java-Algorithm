package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 11000 - 강의실 배정
 * 문제 이해: 시작시간과 종료 시간이 주어졌을 때, 최소의 강의실을 사용해서 모든 수업을 가능하게 하는
 *          강의실 개수를 구하라
 * 시간 복잡도: O(NlogN + N)
 */
public class Pro11000 {
    static int N, res;
    static boolean[] visit;
    static PriorityQueue<Elem> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Elem(start, end));
        }
//        for (int i = 0; i < N; i++) {
//            Elem poll = pq.poll();
//            System.out.println(poll.start + " " + poll.end);
//        }
        pro();
    }

    private static void pro() {
        PriorityQueue<Integer> pq_end = new PriorityQueue<>();

        pq_end.offer(pq.poll().end);
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Elem e = pq.poll();
            if (e.start >= pq_end.peek())
                pq_end.poll();
            pq_end.offer(e.end);
        }
        System.out.println(pq_end.size());
    }

    private static class Elem implements Comparable<Elem> {
        int start;
        int end;

        public Elem(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Elem o) {
            if (this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }
}
