package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1966 - 프린터 큐
 */
public class Pro1966 {
    static int T, N, M;
    static Integer[] arr;
    static Queue<Elem> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            pq = new LinkedList<>();
            arr = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                pq.add(new Elem(i, tmp));
                arr[i] = tmp;
            }
            Arrays.sort(arr, Collections.reverseOrder());
            pro();
        }
    }

    private static void pro() {
        int ans = -1;
        for (int i = 0; i < N; i++) {
            Elem e;
            while (true) {
                e = pq.poll();
                if (e.priority != arr[i]) {
                    pq.add(e);
                } else {
                    break;
                }
            }
            if (e.idx == M) {
                ans = i + 1;
                break;
            }
        }
        System.out.println(ans);
    }

    private static class Elem {
        int idx;
        int priority;

        public Elem(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
