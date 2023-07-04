package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1987 - 알파벳
 */
public class Pro1987 {
    static int R, C, res;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;
    static boolean[] alphabet = new boolean[26];
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        dfs(0, 0, 1);
        System.out.println(res);
    }

    private static void dfs(int r, int c, int cnt) {
        visit[r][c] = true;
        alphabet[map[r][c] - 'A'] = true;
        res = Math.max(res, cnt);

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                continue;
            if (visit[nr][nc])
                continue;
            if (alphabet[map[nr][nc] - 'A'])
                continue;
            dfs(nr, nc, cnt + 1);
            visit[nr][nc] = false;
            alphabet[map[nr][nc] - 'A'] = false;
        }
    }
}
