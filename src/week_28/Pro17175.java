package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 17175 - 피보나치는 지겨웡~
 */
public class Pro17175 {
    public static final int MOD = 1000000007;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new int[n + 1];
        dp[0] = 1;
        if (n >= 1)
            dp[1] = 1;
        if (n >= 2)
            dp[2] = 3;
        if (n >= 3)
            dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 1) % MOD;
        }
        System.out.println(dp[n]);
    }
}
