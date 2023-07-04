package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1577 - 도로의 개수
 */
public class Pro1577 {
    static int N, M, K;
    static boolean[][][] roads;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        roads = new boolean[N + 1][M + 1][2]; // 0 아래로 공사, 1 왼쪽으로 공사
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            if (y1 == y2 && x2 == x1 + 1)
                roads[y2][x2][1] = true;
            else if (y1 == y2 && x1 == x2 + 1)
                roads[y1][x1][1] = true;
            else if (x1 == x2 && y2 == y1 + 1)
                roads[y2][x1][0] = true;
            else
                roads[y1][x1][0] = true;
        }
        pro();
    }

    private static void pro() {
        dp = new long[N + 1][M + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= N; i++) {
            if (roads[i][0][0])
                break;
            dp[i][0] = 1;
        }
        for (int i = 0; i <= M; i++) {
            if (roads[0][i][1])
                break;
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!roads[i][j][0])
                    dp[i][j] += dp[i - 1][j];
                if (!roads[i][j][1])
                    dp[i][j] += dp[i][j - 1];
            }
        }
        System.out.println(dp[N][M]);
    }
}
