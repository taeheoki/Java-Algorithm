package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1932 - 정수 삼각형
 * 문제 이해:
 */
public class Pro1932 {
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }
}
