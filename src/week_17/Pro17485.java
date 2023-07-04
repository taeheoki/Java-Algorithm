package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * # BOJ 17485 - 진우의 달 여행 (Large)
 *
 */
public class Pro17485 {
    static int N, M;
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
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[N - 1][i][j]);
            }
        }
        System.out.println(ans);
    }

    private static void pro() {
        dp = new int[N][M][3];
        for (int j = 0; j < M; j++) {
            if (j != M - 1)
                dp[1][j][0] = map[0][j + 1] + map[1][j];
            else
                dp[1][j][0] = Integer.MAX_VALUE;
            dp[1][j][1] = map[0][j] + map[1][j];
            if (j != 0)
                dp[1][j][2] = map[0][j - 1] + map[1][j];
            else
                dp[1][j][2] = Integer.MAX_VALUE;
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j != M - 1)
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                else
                    dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                if (j != 0)
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
                else
                    dp[i][j][2] = Integer.MAX_VALUE;
            }
        }
    }
}
