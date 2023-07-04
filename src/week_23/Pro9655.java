package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 9655 - 돌 게임
 */
public class Pro9655 {
    static int N;
    static String[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
        System.out.println(dp[N]);
    }

    private static void pro() {
        dp = new String[N + 1];
        if (N >= 1)
            dp[1] = "SK";
        if (N >= 2)
            dp[2] = "CY";
        if (N >= 3)
            dp[3] = "SK";
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1].equals("SK") ? "CY" : "SK";
        }
    }
}
