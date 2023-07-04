package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11726 - 2xn 타일링
 */
public class Pro11726 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new int[N + 1];
        dp[1] = 1;
        if (N >= 2)
            dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[N]);
    }

}
