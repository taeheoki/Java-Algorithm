package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BOJ 10026 - 적록색약
 * 문제 이해: 정상인이 구별하는 RGB 영역과
 *          적록 색약이 구별하는 (RG)B 영역의 구역 수를 구하라
 * 시간 복잡도: 격자형 그래프로 정점을 구하는 O(N^2), 간선 O(N^2 * 4)로
 *           O(N^2)의 시간 복잡도를 가진다.
 */
public class Pro10026 {
    static StringBuilder sb = new StringBuilder();
    static int N, group_cnt;
    static String[] area;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new String[N];
        for (int i = 0; i < N; i++)
            area[i] = br.readLine();
        pro();
    }

    private static void pro() {
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && area[i].charAt(j) == 'R') {
                    dfs(i, j, 'R');
                    group_cnt++;
                } else if (!visit[i][j] && area[i].charAt(j) == 'G') {
                    dfs(i, j, 'G');
                    group_cnt++;
                } else if (!visit[i][j] && area[i].charAt(j) == 'B') {
                    dfs(i, j, 'B');
                    group_cnt++;
                }
            }
        }
        sb.append(group_cnt).append(" ");
        group_cnt = 0;
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && (area[i].charAt(j) == 'R' || area[i].charAt(j) == 'G')) {
                    dfs_RG(i, j);
                    group_cnt++;
                } else if (!visit[i][j] && area[i].charAt(j) == 'B') {
                    dfs(i, j, 'B');
                    group_cnt++;
                }
            }
        }
        sb.append(group_cnt);
        System.out.println(sb);
    }

    private static void dfs(int x, int y, char cmp) {
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0  || nx >= N || ny >= N)
                continue;
            if (area[nx].charAt(ny) != cmp)
                continue;
            if (visit[nx][ny])
                continue;
            dfs(nx, ny, cmp);
        }
    }

    private static void dfs_RG(int x, int y) {
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0  || nx >= N || ny >= N)
                continue;
            if (area[nx].charAt(ny) == 'B')
                continue;
            if (visit[nx][ny])
                continue;
            dfs_RG(nx, ny);
        }
    }
}
