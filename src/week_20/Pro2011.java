package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 2011 - 암호코드
 */
public class Pro2011 {
    public static final int MOD = 1000000;
    static String data;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = br.readLine();
        pro();
    }

    private static void pro() {
        dp = new int[data.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= data.length(); i++) {
            int cur = data.charAt(i - 1) - '0';
            if (cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1] % MOD;
            }
            if (i == 1)
                continue;
            int prev = data.charAt(i - 2) - '0';
            if (prev == 0)
                continue;
            int value = prev * 10 + cur;
            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[data.length()]);
    }
}

/**
 * 1 1 (2)
 * 11
 *
 * 1 1 1 (3)
 * 11 1
 * 1 11
 *
 *
 * 1 1 1 1 (5)
 * 1 1 11
 * 1 11 1
 * 11 1 1
 * 11 11
 *
 * 8 -> 13 -> 21 -> 34 -> 55 -> 89 피보나치수열이네!!!!
 */
