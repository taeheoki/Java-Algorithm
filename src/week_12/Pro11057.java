package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11057 - 오르막 수
 * 문제 이해: 수의 길이 N이 주어졌을 때 오르막 수의 개수를 구하라.
 */
public class Pro11057 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % 10007;
        }
        System.out.println(sum);
    }
}
