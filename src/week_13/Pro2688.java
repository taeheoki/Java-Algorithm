package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 2688 - 줄어들지 않아
 */
public class Pro2688 {
    static int T, n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            pro();
        }
    }

    private static void pro() {
        dp = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        System.out.println(Arrays.stream(dp[n]).sum());
    }
}
