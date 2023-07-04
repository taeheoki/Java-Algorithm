package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1743 - 음식물 피하기
 * 문제 이해: 음식물이 뭉치게 돼 큰 음식물 쓰레기가 되어 있다. 이때 뭉친 음쓰 중 가장 큰 음식물 쓰레기를 피해가기 위해
 *          음식물 쓰레기의 크기를  구해보자
 * 시간 복잡도: O(NM)
 *           N * M 을 단순 조회한다.
 */
public class Pro1743 {

    static int N, M, K, res, cnt = Integer.MIN_VALUE;
    static int[][] map, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = 1;
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j])
                    continue;
                if (map[i][j] == 1) {
                    res = 0;
                    dfs(i, j);
                    cnt = Math.max(cnt, res);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;
        res++;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                continue;
            if (visit[ny][nx])
                continue;
            if (map[ny][nx] == 0)
                continue;
            dfs(ny, nx);
        }
    }
}
