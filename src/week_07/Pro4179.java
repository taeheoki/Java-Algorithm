package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 4179 - 불!
 * 문제 이해: 불이 지훈이에게 도달하기 전에 탈출구가 있는 가쪽 벽에 지훈이가
 *          도착하기 까지 걸리는 시간을 구하고,
 *          만일 탈출하기 전에 불에 도착하거나, 가쪽 벽에 도달할 수 없어 탈출 할 수 없다면
 *          'IMPOSSIBLE'을 출력하라.
 * 시간 복잡도: O(RC)
 */
public class Pro4179 {
    static int R, C, ans = Integer.MAX_VALUE;
    static int[][] visit_F, visit_J, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit_F = new int[R][C];
        visit_J = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'F') {
                    q.offer(j);
                    q.offer(i);
                    visit_F[i][j] = 1;
                }
            }
        }
        pro();
    }

    private static void pro() {
        bfs_F();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J')
                    bfs_J(j, i);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((i == 0 || i == R -1 || j == 0 || j == C - 1) && visit_J[i][j] != 0) {
                    ans = Math.min(ans, visit_J[i][j]);
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(ans);
    }

    private static void bfs_J(int start_x, int start_y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_x);
        queue.offer(start_y);
        visit_J[start_y][start_x] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                    continue;
                if (visit_J[ny][nx] > 0)
                    continue;
                if (map[ny][nx] == '#')
                    continue;
                if (visit_F[ny][nx] <= visit_J[y][x] + 1 && visit_F[ny][nx] != 0)
                    continue;
                queue.offer(nx);
                queue.offer(ny);
                visit_J[ny][nx] = visit_J[y][x] + 1;
            }
        }
    }

    private static void bfs_F() {
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                    continue;
                if (visit_F[ny][nx] > 0)
                    continue;
                if (map[ny][nx] == '#')
                    continue;
                q.offer(nx);
                q.offer(ny);
                visit_F[ny][nx] = visit_F[y][x] + 1;
            }
        }
    }
}
