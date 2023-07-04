package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2579 - 계단 오르기
 */
public class Pro2579 {
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n + 1][2];
        pro();
    }

    private static void pro() {
        // 초기값 구하기
        dp[0][0] = 0;
        dp[0][1] = arr[0];

        if (n >= 2) {
            dp[1][0] = arr[1];
            dp[1][1] = arr[0] + arr[1];
        }

        // 점화식을 토대로 dp 배열 채우기
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
            dp[i][1] = dp[i - 1][0] + arr[i];
        }

        // dp 배열로 정답 계산하기
        int ans = Math.max(dp[n - 1][0], dp[n - 1][1]);
        System.out.println(ans);
    }
}
