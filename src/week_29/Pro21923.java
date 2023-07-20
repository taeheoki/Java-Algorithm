package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 21923 - 곡예 비행
 */
public class Pro21923 {
    static int N, M, res = Integer.MIN_VALUE;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        dp = new int[N][M][2];
        dp[N - 1][0][0] = map[N - 1][0];
        for (int i = N-1; i >= 0; i--) {
            if (i != N - 1) {
                dp[i][0][0] = dp[i + 1][0][0] + map[i][0];
            }
            for (int j = 1; j < M; j++) {
                if (i != N - 1) {
                    dp[i][j][0] = Math.max(dp[i + 1][j][0], dp[i][j - 1][0]) + map[i][j];
                } else {
                    dp[i][j][0] = dp[i][j - 1][0] + map[i][j];
                }
            }
        }

        dp[N - 1][M - 1][1] = map[N - 1][M - 1];
        for (int i = N-1; i >= 0; i--) {
            if (i != N - 1) {
                dp[i][0][0] = dp[i + 1][0][0] + map[i][0];
            }
            for (int j = 1; j < M; j++) {
                if (i != N - 1) {
                    dp[i][j][0] = Math.max(dp[i + 1][j][0], dp[i][j - 1][0]) + map[i][j];
                } else {
                    dp[i][j][0] = dp[i][j - 1][0] + map[i][j];
                }
            }
        }
        for (int i = N-1; i >= 0; i--) {
            if (i != N - 1) {
                dp[i][M - 1][1] = dp[i + 1][M - 1][1] + map[i][M - 1];
            }
            for (int j = M - 2; j >= 0; j--) {
                if (i != N - 1) {
                    dp[i][j][1] = Math.max(dp[i + 1][j][1], dp[i][j + 1][1]) + map[i][j];
                } else {
                    dp[i][j][1] = dp[i][j + 1][1] + map[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res = Math.max(res, dp[i][j][0]+ dp[i][j][1]);
            }
        }
        System.out.println(res);
    }


}
