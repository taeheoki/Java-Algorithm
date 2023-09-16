package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17484 - 진우의 달 여행 (Small)
 */
public class BOJ17484 {
    static int N, M, res = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1};
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        dp = new int[N][M];

        dp[0] = arr[0].clone();
        for (int j = 0; j < M; j++)
            dp[N - 1][j] = dfs(N - 1 , j, 2);

        for (int i = 0; i < M; i++) {
            res = Math.min(res, dp[N - 1][i]);
        }
        System.out.println(res);
    }

    private static int dfs(int y, int x, int dir) {
        int score = Integer.MAX_VALUE;
        if (y == 0)
            return arr[y][x];
        for (int direction : dx) {
            if (dir == direction)
                continue;
            if (x == 0 && direction == -1)
                continue;
            if (x == M -1 && direction == 1)
                continue;
            score = Math.min(score, dfs(y - 1, x + direction, direction) + arr[y][x]);
        }
        return score;
    }
}
