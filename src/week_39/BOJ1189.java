package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1189 - 컴백홈
 */
public class BOJ1189 {
    static int R, C, K, res;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[R][C];
        visit[R - 1][0] = true;
        dfs(1, R - 1, 0);
        System.out.println(res);
    }

    private static void dfs(int depth, int y, int x) {
        if (depth == K) {
            if (y == 0 && x == C - 1)
                res++;
            return;
        }
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C)
                continue;
            if (board[ny][nx] == 'T')
                continue;
            if (visit[ny][nx])
                continue;
            visit[ny][nx] = true;
            dfs(depth + 1, ny, nx);
            visit[ny][nx] = false;
        }
    }
}
