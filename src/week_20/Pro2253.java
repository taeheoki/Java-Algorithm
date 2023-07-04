package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2253 - 점프
 */
public class Pro2253 {
    static int N, M;
    static int[][] dp;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][(int) Math.pow(2 * N, 0.5) + 2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 10000);
        }
        dp[1][0] = 0;
        for (int i = 2; i <= N; i++) {
            if (set.contains(i))
                continue;
            for (int j = 1; j <= (int) Math.sqrt(2 * i); j++) {
                dp[i][j] = Math.min(dp[i - j][j - 1], Math.min(dp[i - j][j], dp[i - j][j + 1])) + 1;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 1; j <= (int) Math.pow(2 * N, 0.5); j++) {
            result = Math.min(result, dp[N][j]);
        }
        if (result >= 10000)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}
