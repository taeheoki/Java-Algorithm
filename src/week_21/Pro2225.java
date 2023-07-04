package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2225 - 합분해
 */
public class Pro2225 {
    public static final int MOD = 1000000000;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[j][i] = (dp[j][i] + dp[k][i - 1]) % MOD;
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
