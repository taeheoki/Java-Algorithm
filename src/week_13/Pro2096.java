package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2096 - 내려가기
 */
public class Pro2096 {
    static int N, min = Integer.MAX_VALUE, max;
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][3][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                dp[1][j][i] = arr[1][j];
            }
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (j + k < 0 || j + k >= 3)
                        continue;
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j + k][0] + arr[i][j]);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j + k][1] + arr[i][j]);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp[N][i][0]);
            min = Math.min(min, dp[N][i][1]);
        }
        System.out.println(max + " " + min);
    }
}
