package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1309 - 동물원
 */
public class Pro1309 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][3];
        dp[1][0] = 1; // 공백
        dp[1][1] = 1; // 왼쪽
        dp[1][2] = 1; // 오른쪽
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }
}
