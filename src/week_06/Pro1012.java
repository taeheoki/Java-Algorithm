package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1012 - 유기농 배추
 * 문제 이해: 배추가 심어져 있는 농장에 유기농을 위해 배추흰지렁이를 풀어야하는데, 구역별로 풀 때
 *          필요한 배추흰지렁이의 수를 구하라.
 * 시간 복잡도: O(MN)
 */
public class Pro1012 {
    static int T, M, N, K, X, Y, ans;
    static int[][] map, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken()); // 가로위치
                Y = Integer.parseInt(st.nextToken()); // 세로위치
                map[Y][X] = 1;
            }
            pro();
        }
    }

    private static void pro() {
        visit = new boolean[N][M];
        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }


    private static void dfs(int y, int x) {
        visit[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
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
