package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2156 - 포도주 시식
 * 문제 이해: 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 *          효주를 도와 가장 많은 양의 포도주를 마실 수 있는 프로그램을 만들어 보자.
 */
public class Pro2156 {
    static int n, res;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        dp = new int[n + 1][2];
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];
        res = Math.max(res, Math.max(dp[1][0], dp[1][1]));
        if (n >= 2) {
            dp[2][0] = arr[2];
            dp[2][1] = arr[1] + arr[2];
            res = Math.max(res, Math.max(dp[2][0], dp[2][1]));
        }
        for (int i = 3; i <= n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 3][0], dp[i - 3][1]), Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i];
            dp[i][1] = dp[i - 1][0] + arr[i];
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(res);
    }
}
