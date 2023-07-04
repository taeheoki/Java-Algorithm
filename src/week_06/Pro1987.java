package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1987 - 알파벳
 * 문제 이해:
 */
public class Pro1987 {
    static int R, C, ans;
    static boolean[] used = new boolean[26];
    static int[][] visit, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++)
                map[i][j] = str.charAt(j);
        }
        pro();
    }

    private static void pro() {
        visit = new int[R][C];
        used[map[0][0] - 'A'] = true;
        visit[0][0] = 1;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int y, int x, int cnt) {
        ans = Math.max(ans, cnt);

        for (int dir[] : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                continue;
            }
            if (visit[ny][nx] > 0) {
                continue;
            }
            if (used[map[ny][nx] - 'A']) {
                continue;
            }
            visit[y][x] = cnt;
            used[map[ny][nx] - 'A'] = true;
            dfs(ny, nx, cnt + 1);
            visit[y][x] = 0;
            used[map[ny][nx] - 'A'] = false;
        }
    }
}
