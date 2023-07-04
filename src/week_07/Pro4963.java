package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 4963 - 섬의 개수
 * 문제 이해: 상하좌우, 대각선으로 움직일 수 있을 때 섬의 개수를 구하라.
 * 시간 복잡도: O(wh * times)
 */
public class Pro4963 {
    static int w, h;
    static int[][] map, dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0)
                break;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            pro();
        }
    }

    private static void pro() {
        int cnt = 0;
        visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) { // x : 높이, y : 너비
        visit[x][y] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= h || ny >= w)
                continue;
            if (visit[nx][ny])
                continue;
            if (map[nx][ny] == 0)
                continue;
            dfs(nx, ny);
        }
    }
}
