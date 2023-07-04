package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 14502 - 연구소
 * 문제 이해: 바이러스가 창궐할 때 적절하게 벽을 세워 막게 전염을 막았을 때
 *          확보되는 안전지역의 최대값
 *          벽을 세우는 구현 * (전체 - (바이러스가 창궐한 영역 + 벽 영역))
 * 시간 복잡도: O(MN(Brute Force) * MN)
 */
public class Pro14502 {
    static int N, M, cnt, ans = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[N][M];
        rec_func(0);
        System.out.println(ans);
    }

    private static void rec_func(int depth) {
        if (depth == 3) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    visit[i][j] = false;
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2 && !visit[i][j]) {
                        dfs(i, j);
                    } else if (map[i][j] == 1)
                        cnt++;
                }
            }
            ans = Math.max((M * N - cnt), ans);
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0)
                        continue;
                    map[i][j] = 1;
                    rec_func(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;
            if (visit[nx][ny])
                continue;
            if (map[nx][ny] == 1)
                continue;
            dfs(nx, ny);
        }
    }
}