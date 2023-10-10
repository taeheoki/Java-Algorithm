package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ2468 - 안전 영역
 */
public class BOJ2468 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, res;
    static int[][] board, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] flood;

    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(flood[j], false);
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] > i && !flood[j][k]) {
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }

    private static void dfs(int y, int x, int height) {
        flood[y][x] = true;

        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                continue;
            if (board[ny][nx] <= height || flood[ny][nx])
                continue;
            dfs(ny, nx, height);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }
        flood = new boolean[N][N];
    }
}
