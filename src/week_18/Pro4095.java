package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 4095 - 최대 정사각형
 */
public class Pro4095 {
    static int N, M, ans;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0)
                break;
            map = new int[N][M];
            dp = new int[N + 1][M + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            pro();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void pro() {
        ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i - 1][j- 1] == 1) {
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = min + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans);
    }
}
