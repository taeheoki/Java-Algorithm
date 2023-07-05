package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 17212 - 달나라 토끼를 위한 구매대금 지불 도우미
 */
public class Pro17212 {
    static int N;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new int[N + 1];
        dp[0] = 0;
        if (N >= 1)
            dp[1] = 1;
        if (N >= 2)
            dp[2] = 1;
        if (N >= 3)
            dp[3] = 2;
        if (N >= 4)
            dp[4] = 2;
        if (N >= 5)
            dp[5] = 1;
        if (N >= 6)
            dp[6] = 2;
        if (N >= 7)
            dp[7] = 1;
        for (int i = 8; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 2], Math.min(dp[i - 5], dp[i - 7]))) + 1;
        }
        System.out.println(dp[N]);
    }
}
