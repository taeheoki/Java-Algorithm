package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2573 - 빙산
 */
public class Pro2573 {
    static int N, M, time;
    static int[][] map, meltingIceberg, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        meltingIceberg = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
        System.out.println(time);
    }

    private static void pro() {
        while (true) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && map[i][j] != 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt >= 2 || cnt == 0) {
                if (cnt == 0)
                    time = 0;
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visit[i][j] = false;
                    map[i][j] = map[i][j] - meltingIceberg[i][j] > 0 ? map[i][j] - meltingIceberg[i][j] : 0;
                    meltingIceberg[i][j] = 0;
                }
            }
            time++;
        }
    }

    private static void bfs(int i, int j) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        que.add(j);
        visit[i][j] = true;

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();

            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                    continue;
                if (visit[ny][nx])
                    continue;
                if (map[ny][nx] == 0) {
                    meltingIceberg[y][x]++;
                    continue;
                }
                que.add(ny);
                que.add(nx);
                visit[ny][nx] = true;
            }
        }
    }
}
