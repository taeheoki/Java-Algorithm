package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2178 - 미로 탐색
 * 문제 이해: (N, M)의 위치로 가기까지의 count
 * 시간 복잡도: O(NM)
 */
public class Pro2178 {

    static int N, M;
    static char[][] map;
    static int[][] visit, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = str.charAt(j);
        }
        pro();
    }

    private static void pro() {
        visit = new int[N][M];
        bfs();
        System.out.println(visit[N - 1][M - 1]);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N && cur[1] == M)
                return;
            for (int[] dir : dirs) {
                int nx = cur[1] + dir[1];
                int ny = cur[0] + dir[0];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                if (map[ny][nx] == '0')
                    continue;
                if (visit[ny][nx] > 0)
                    continue;
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = visit[cur[0]][cur[1]] + 1;
            }
        }
    }
}
