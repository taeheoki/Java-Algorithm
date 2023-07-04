package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1987 - 알파벳
 */
public class Pro1987 {
    static int R, C, res;
    static int[][] map, dirs = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static boolean[] alphabet = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String data = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = data.charAt(j);
            }
        }
        alphabet[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(res);
    }

    private static void dfs(int y, int x, int cnt) {
        res = Math.max(res, cnt);
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C)
                continue;
            if (visit[ny][nx])
                continue;
            if (alphabet[map[ny][nx] - 'A'])
                continue;
            visit[ny][nx] = true;
            alphabet[map[ny][nx] - 'A'] = true;
            dfs(ny, nx, cnt + 1);
            visit[ny][nx] = false;
            alphabet[map[ny][nx] - 'A'] = false;
        }
    }
}
