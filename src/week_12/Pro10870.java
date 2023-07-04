package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 10870 - 피보나치 수 5
 */
public class Pro10870 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
        System.out.println(dp[N]);
    }

    private static void pro() {
        dp = new int[N + 1];
        dp[0] = 0;
        if (N >= 1) {
            dp[1] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
}
