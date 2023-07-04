package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 7576 - 토마토
 * 문제 이해: 상하좌우 익은 토마토가 아직 익지 않은 토마토에게 영향을 줄 때,
 *          토마토가 다 익는데까지 걸리는 시간을 계산하라, 전부다 익을 수 없는 경우 -1을 반환
 *          갈 수 있는 방향별로 날짜가 카운팅 되어야 하기 때문에 bfs가 적당하다 생각된다.
 * 시간 복잡도: M * N
 */
public class Pro7576 {
    static int M, N, ans;
    static int[][] map, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] visit;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = 1;
                }
            }
        }
        pro();
    }

    private static void pro() {
        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == 0 && map[i][j] != -1 &&  map[i][j] != 1) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, visit[i][j]);
            }
        }
        System.out.println(ans - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dir[i][1];
                int ny = cur[0] + dir[i][0];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                if (map[ny][nx] == -1)
                    continue;
                if (visit[ny][nx] > 0)
                    continue;
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = visit[cur[0]][cur[1]] + 1;
            }
        }
    }
}
