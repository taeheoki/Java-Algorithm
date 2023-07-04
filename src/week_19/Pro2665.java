package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 2665 - 미로만들기
 */
public class Pro2665 {
    static int N, ans = -1;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;
    static boolean[][][] visited; // 추가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N][N * N]; // 초기화
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        for (int i = 0; i < N * N; i++) {
            ans = bfs(i);
            if (ans >= 0)
                break;
        }
        System.out.println(ans);
    }

    private static int bfs(int k) {
        Queue<Elem> que = new LinkedList<>();
        que.add(new Elem(0, 0, k, 0));

        while (!que.isEmpty()) {
            Elem cur = que.poll();
            if (cur.y == N - 1 && cur.x == N - 1) {
                return k;
            }

            // 방문 체크
            if (visited[cur.y][cur.x][cur.k]) {
                continue;
            }
            visited[cur.y][cur.x][cur.k] = true;

            for (int[] dir : dirs) {
                int ny = cur.y + dir[0];
                int nx = cur.x + dir[1];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                    continue;
                if (map[ny][nx] == '0' && cur.k == 0)
                    continue;
                if (map[ny][nx] == '0') {
                    que.add(new Elem(ny, nx, cur.k - 1, cur.count + 1));
                } else
                    que.add(new Elem(ny, nx, cur.k, cur.count + 1));
            }
        }
        return -1;
    }

    private static class Elem {
        int y;
        int x;
        int k;
        int count;

        public Elem(int y, int x, int k, int count) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }
}
