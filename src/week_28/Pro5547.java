package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 5547 - 일루미네이션
 */
public class Pro5547 {
    static int W, H, cnt;
    static int[][] map, oddDirs = {{0, -1}, {1, -1}, {-1, 0}, {1, 0}, {0, 1}, {1, 1}}, evenDirs = {{-1, -1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[W + 2][H + 2];
        for (int j = 1; j <= H; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= W; i++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[W + 2][H + 2];
        // 벽면 안에 빈칸이 있을 경우 벽으로 채우고 시작
        fillWithWall(0, 0);

        // 벽면 계산
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= H; j++) {
                if (!visit[i][j] && map[i][j] == 1)
                    dfs(i, j);
            }
        }
        System.out.println(cnt);
    }

    private static void fillWithWall(int x, int y) {
        map[x][y] = 2;

        if (y % 2 == 1) {
            for (int[] oddDir : oddDirs) {
                int nx = x + oddDir[0];
                int ny = y + oddDir[1];
                if (nx < 0 || ny < 0 || nx >= W + 2 || ny >= H + 2)
                    continue;
                if (map[nx][ny] != 0)
                    continue;
                fillWithWall(nx, ny);
            }
        } else {
            for (int[] evenDir : evenDirs) {
                int nx = x + evenDir[0];
                int ny = y + evenDir[1];
                if (nx < 0 || ny < 0 || nx >= W + 2 || ny >= H + 2)
                    continue;
                if (map[nx][ny] != 0)
                    continue;
                fillWithWall(nx, ny);
            }
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        if (y % 2 == 1) {
            for (int[] oddDir : oddDirs) {
                int nx = x + oddDir[0];
                int ny = y + oddDir[1];
                if (nx < 0 || ny < 0 || nx >= W + 2 || ny >= H + 2)
                    continue;
                if (map[nx][ny] == 2)
                    cnt++;
                else if (!visit[nx][ny] && map[nx][ny] == 1)
                    dfs(nx, ny);
            }
        } else {
            for (int[] evenDir : evenDirs) {
                int nx = x + evenDir[0];
                int ny = y + evenDir[1];
                if (nx < 0 || ny < 0 || nx >= W + 2 || ny >= H + 2)
                    continue;
                if (map[nx][ny] == 2)
                    cnt++;
                else if (!visit[nx][ny] && map[nx][ny] == 1)
                    dfs(nx, ny);
            }
        }
    }
}
