package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11727 - 2xn 타일링 2
 */
public class BOJ11727 {
    static int n;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new int[n + 1];

        dp[1] = 1;
        if (n >= 2)
            dp[2] = 3;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;

        System.out.println(dp[n]);
    }
}
