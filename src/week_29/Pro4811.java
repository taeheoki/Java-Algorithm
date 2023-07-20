package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 4811 - 알약
 */
public class Pro4811 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            sb.append(rec_func(N, 0)).append('\n');
        }
        System.out.println(sb);
    }

    private static long rec_func(int w, int h) {
        if (w == 0 && h == 0)
            return 1;
        if (dp[w][h] != 0)
            return dp[w][h];
        if (w != 0) {
            dp[w][h] += rec_func(w - 1, h + 1);
        }
        if (h != 0) {
            dp[w][h] += rec_func(w, h - 1);
        }
        return dp[w][h];
    }
}
