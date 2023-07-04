package src.week_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 10844 - 쉬운 계단 수
 */
public class Pro10844 {
    public static final int MOD = 1000000000;
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][10];
        for (int i = 1; i <= 9; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % MOD;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][5]) % MOD;
            dp[i][5] = (dp[i - 1][4] + dp[i - 1][6]) % MOD;
            dp[i][6] = (dp[i - 1][5] + dp[i - 1][7]) % MOD;
            dp[i][7] = (dp[i - 1][6] + dp[i - 1][8]) % MOD;
            dp[i][8] = (dp[i - 1][7] + dp[i - 1][9]) % MOD;
            dp[i][9] = dp[i - 1][8];
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }
        System.out.println(sum);
    }
}
