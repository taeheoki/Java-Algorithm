package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2579 - 계단 오르기
 */
public class Pro2579 {
    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][2];
        // dp[][0]: 이전에 계단 한 칸, dp[][1]: 계단 두 칸

        dp[1][0] = arr[1];
        if (N >= 2) {
            dp[2][0] = arr[2] + arr[1]; // 30
            dp[2][1] = arr[2]; // 20
        }
        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
