package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 21610 - 마법사 상어와 비바라기
 */
public class Pro21610 {
    static int N, M;
    static int[][] map,
            dirs = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}},
            diagonals = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Cloud> clouds = new LinkedList<>();
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int offset = Integer.parseInt(st.nextToken());
            step12(clouds, direction, offset);
            step34(clouds);
            step5(clouds);
        }
        int sum = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                sum += map[y][x];
            }
        }
        System.out.println(sum);
    }

    private static void step5(Queue<Cloud> clouds) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
                visit[i][j] = false;
            }
        }
    }

    private static void step34(Queue<Cloud> clouds) {
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();
            map[cloud.y][cloud.x] += getIncrease(cloud.y, cloud.x);
            visit[cloud.y][cloud.x] = true;
        }
    }

    private static void step12(Queue<Cloud> clouds, int direction, int offset) {
        for (Cloud cloud : clouds) {
            cloud.y = (N + cloud.y + dirs[direction][0] * (offset % N)) % N;
            cloud.x = (N + cloud.x + dirs[direction][1] * (offset % N)) % N;
            map[cloud.y][cloud.x]++;
        }
    }

    private static int getIncrease(int y, int x) {
        int cnt = 0;
        for (int[] diagonal : diagonals) {
            int ny = y + diagonal[0];
            int nx = x + diagonal[1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                continue;
            if (map[ny][nx] > 0)
                cnt++;
        }
        return cnt;
    }

    private static class Cloud {
        int y;
        int x;

        public Cloud(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cloud cloud = (Cloud) o;
            return y == cloud.y && x == cloud.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
