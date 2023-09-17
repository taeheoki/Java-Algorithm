package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ 1446 - 지름길
 */
public class BOJ1446 {
    static int N, D;
    static int[] dp;
    static ArrayList<Elem> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end > D || end - start <= dist)
                continue;
            arr.add(new Elem(start, end, dist));
        }
        Collections.sort(arr, (a, b) -> a.start - b.start);
        pro();
        System.out.println(dp[D]);
    }

    private static void pro() {
        dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = 0; j < arr.size(); j++) {
                Elem e = arr.get(j);
                if (e.end < i)
                    continue;
                else if (e.end == i && e.start < i) {
                    dp[i] = Math.min(dp[i], dp[e.start] + e.dist);
                }
            }
        }
    }

    private static class Elem {
        int start;
        int end;
        int dist;

        public Elem(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
}
