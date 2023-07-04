package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 14940 - 쉬운 최단거리
 */
public class Pro14940 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] map, visit, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    que.offer(j);
                    que.offer(i);
                    visit[i][j] = 0;
                }
            }
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1)
                    visit[i][j] = -1;
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(visit[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;
                if (visit[ny][nx] != -1)
                    continue;
                if (map[ny][nx] == 0)
                    continue;
                que.offer(nx);
                que.offer(ny);
                visit[ny][nx] = visit[y][x] + 1;
            }
        }
    }
}
