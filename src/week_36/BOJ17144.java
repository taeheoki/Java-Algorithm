package src.week_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 17144 - 미세먼지 안녕!
 */
public class BOJ17144 {
    static int R, C, T;
    static int[] machine = new int[2];
    static int[][] map, copyMap, dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == - 1) {
                    machine[0] = i - 1;
                    machine[1] = i;
                }
            }
        }
        pro();
        System.out.println(getDustCnt());
    }

    private static void pro() {
        copyMap = new int[R][C];
//        copyMap[machine[0]][0] = -1;
//        copyMap[machine[1]][0] = -1;
        while (T-- > 0) {
            // 미세먼지 확산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0)
                        spread(i, j, map[i][j]);
                }
            }

            // 공기 청정기 작동
            // 위
            for (int i = machine[0] - 1; i >= 1; i--) {
                copyMap[i][0] = copyMap[i - 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                copyMap[0][i] = copyMap[0][i + 1];
            }
            for (int i = 0; i < machine[0]; i++) {
                copyMap[i][C - 1] = copyMap[i + 1][C - 1];
            }
            for (int i = C - 1; i >= 1; i--) {
                copyMap[machine[0]][i] = copyMap[machine[0]][i - 1];
            }
            // 아래
            for (int i = machine[1] + 1; i < R - 1; i++) {
                copyMap[i][0] = copyMap[i + 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                copyMap[R - 1][i] = copyMap[R - 1][i + 1];
            }
            for (int i = R - 1; i > machine[1]; i--) {
                copyMap[i][C - 1] = copyMap[i - 1][C - 1];
            }
            for (int i = C - 1; i >= 1; i--) {
                copyMap[machine[1]][i] = copyMap[machine[1]][i - 1];
            }


            for (int i = 0; i < R; i++) {
                map[i] = copyMap[i].clone();
                Arrays.fill(copyMap[i], 0);
            }
        }
    }

    private static void spread(int y, int x, int dust) {
        int cnt = 0;
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C)
                continue;
            if ((ny == machine[0] || ny == machine[1]) && nx == 0)
                continue;
            cnt++;
            copyMap[ny][nx] += map[y][x] / 5;
        }
        copyMap[y][x] += map[y][x] - (map[y][x] / 5) * cnt;
    }

    public static int getDustCnt() {
        int dustCnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dustCnt += map[i][j];
            }
        }
        return dustCnt;
    }
}
