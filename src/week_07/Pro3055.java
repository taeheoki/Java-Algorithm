package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 3055 - 탈출
 */
public class Pro3055 {
    static int R, C;
    static char[][] map;
    static Queue<Integer> queue = new LinkedList<>();
    static Queue<Integer> queue_S = new LinkedList<>();
    static int[][] visit_water, visit_S, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit_water = new int[R][C];
        visit_S = new int[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == '*') {
                    queue.offer(j);
                    queue.offer(i);
                    visit_water[i][j] = 1;
                } else if (map[i][j] == 'S') {
                    queue_S.offer(j);
                    queue_S.offer(i);
                    visit_S[i][j] = 1;
                }
            }
        }
        pro();
    }

    private static void pro() {
        bfs_water();
        bfs_D();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'D') {
                    if (visit_S[i][j] == 0)
                        System.out.println("KAKTUS");
                    else
                        System.out.println(visit_S[i][j] - 1);
                }
            }
        }
    }

    private static void bfs_water() {
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                    continue;
                if (visit_water[ny][nx] > 0)
                    continue;
                if (map[ny][nx] == 'X' || map[ny][nx] == 'D')
                    continue;
                queue.offer(nx);
                queue.offer(ny);
                visit_water[ny][nx] = visit_water[y][x] + 1;
            }
        }
    }

    private static void bfs_D() {
        while (!queue_S.isEmpty()) {
            int x = queue_S.poll();
            int y = queue_S.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                    continue;
                if (visit_S[ny][nx] > 0)
                    continue;
                if (map[ny][nx] == 'X')
                    continue;
                if (visit_water[ny][nx] <= visit_S[y][x] + 1 && visit_water[ny][nx] != 0)
                    continue;
                queue_S.offer(nx);
                queue_S.offer(ny);
                visit_S[ny][nx] = visit_S[y][x] + 1;
            }
        }
    }
}
