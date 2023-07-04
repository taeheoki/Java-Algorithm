package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 2346 - 풍선 터뜨리기
 */
public class Pro2346 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Deque<Elem> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.add(new Elem(i, Integer.parseInt(st.nextToken())));
        }
        pro();
        System.out.println(sb);
    }

    private static void pro() {
        while (true) {
            Elem cur = deque.poll();
            sb.append(cur.idx).append(' ');

            if (deque.isEmpty())
                break;

            if (cur.num > 0) {
                for (int i = 0; i < cur.num - 1; i++) {
                    Elem e = deque.pollFirst();
                    deque.add(e);
                }
            } else {
                for (int i = 0; i < -cur.num; i++) {
                    Elem e = deque.pollLast();
                    deque.addFirst(e);
                }
            }
        }
    }

    private static class Elem {
        int idx;
        int num;

        public Elem(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
