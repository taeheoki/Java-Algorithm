package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2573 - 빙산
 * 문제 이해: 빙하가 녹는 조건을 고려하여, 전체 지도에서 빙하가 두 덩이로 남게 되었을 때,
 *          몇년이 걸리는지 계산하라, 빙하가 두 덩이로 남지 않을 경우 0을 출력
 * 시간 복잡도: 최악의 경우 300(N) * 300(M) * 10 = 900,000회의 연산이 발생한다.
 *          O(NMT) T: 빙하가 두덩이 이상 되기까지 걸리는 시간
 */
public class Pro2573 {

    static int N, M, cnt_year, cnt_area;
    static int[][] map, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N][M];
        while (true) {
            cnt_area = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && map[i][j] > 0) {
                        dfs(i, j);
                        cnt_area++;
                    }
                }
            }
            if (cnt_area > 1) {
                break;
            } else if (cnt_area == 0) {
                cnt_year = 0;
                break;
            }
            // 시간의 흐름
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        for (int[] dir : dirs) {
                            int nj = j + dir[0];
                            int ni = i + dir[1];
                            if (nj < 0 || ni < 0 || nj >= M || i >= N)
                                continue;
                            if (map[i][j] != 0 && map[ni][nj] == 0 && !visit[ni][nj]) {
                                map[i][j]--;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visit[i][j] = false;
                }
            }
            cnt_year++;
        }
        System.out.println(cnt_year);
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                continue;
            if (visit[ny][nx])
                continue;
            if (map[ny][nx] == 0) {
                continue;
            }
            dfs(ny, nx);
        }
    }
}
