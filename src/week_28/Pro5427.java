package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 5427 - 불
 */
public class Pro5427 {
    static StringBuilder sb = new StringBuilder();
    static int T, w, h, sr, sc;
    static int[][] visit, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;
    static Queue<Integer[]> queWithFire = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visit = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(visit[i], -1);
            }
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*') {
                        queWithFire.add(new Integer[]{i, j});
                        visit[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        sr = i;
                        sc = j;
                    }
                }
            }
            pro();
            if (T != 0)
                sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        // 불 확산을 위한 bfs()
        bfsForFire();
        // 상근이의 이동을 위한 bfs()
        bfsForSanggeun();
    }

    private static void bfsForFire() {
        while (!queWithFire.isEmpty()) {
            Integer[] cur = queWithFire.poll();
            for (int[] dir : dirs) {
                int ny = cur[0] + dir[0];
                int nx = cur[1] + dir[1];
                if (ny < 0 || nx < 0 || ny >= h || nx >= w)
                    continue;
                if (map[ny][nx] == '#' || map[ny][nx] == '@')
                    continue;
                if (visit[ny][nx] != -1 && visit[ny][nx] <= visit[cur[0]][cur[1]] + 1)
                    continue;
                visit[ny][nx] = visit[cur[0]][cur[1]] + 1;
                queWithFire.add(new Integer[]{ny, nx});
            }
        }
    }

    private static void bfsForSanggeun() {
        Queue<Integer> que = new LinkedList<>();
        que.add(sr);
        que.add(sc);
        visit[sr][sc] = 0;

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();

            if (y == 0 || x == 0 || y == h - 1 || x == w - 1) {
                sb.append(visit[y][x] + 1);
                return;
            }

            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                if (ny < 0 || nx < 0 || ny >= h || nx >= w)
                    continue;
                if (map[ny][nx] == '#')
                    continue;
                if (visit[ny][nx] <= visit[y][x] + 1)
                    if (visit[ny][nx] != -1)
                        continue;
                visit[ny][nx] = visit[y][x] + 1;
                que.add(ny);
                que.add(nx);
            }
        }
        sb.append("IMPOSSIBLE");
    }
}
