package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17144 - 미세먼지 안녕!
 */
public class Pro17144 {
    static int R, C, T, up, down;
    static int[][] map, tmpMap, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        tmpMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i >= 1 && map[i][j] == -1) {
                    up = i - 1;
                    down = i;
                }
            }
        }
        pro();
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1)
                    continue;
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void pro() {
        while (T-- > 0) {
            copyMap();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (tmpMap[i][j] > 0) {
                        spreadDust(i, j);
                    }
                }
            }
            if (!(up == down))
                spreadDustByAirPurifier();
        }
    }

    private static void spreadDustByAirPurifier() {
        copyMap();
        map[up][1] = 0;
        map[down][1] = 0;
        for (int i = 2; i < C; i++) { // 오른쪽
            map[up][i] = tmpMap[up][i - 1];
            map[down][i] = tmpMap[down][i - 1];
        }
        for (int i = 0; i < up; i++) { // 업사이드 위
            map[i][C - 1] = tmpMap[i + 1][C - 1];
        }
        for (int i = down; i < R - 1; i++) { // 다운사이드 아래
            map[i + 1][C - 1] = tmpMap[i][C - 1];
        }
        for (int i = C - 2; i >= 0; i--) { // 왼쪽
            map[0][i] = tmpMap[0][i + 1];
            map[R - 1][i] = tmpMap[R - 1][i + 1];
        }
        for (int i = 1; i < up; i++) { // 업사이드 다운
            map[i][0] = tmpMap[i - 1][0];
        }
        for (int i = R - 2; i > down; i--) { // 다운사이드 위로
            map[i][0] = tmpMap[i + 1][0];
        }
    }

    private static void copyMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
    }

    private static void spreadDust(int y, int x) {
        int cnt = 0;
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                continue;
            if (tmpMap[ny][nx] == -1)
                continue;
            map[ny][nx] += tmpMap[y][x] / 5;
            cnt++;
        }
        map[y][x] -= (tmpMap[y][x] / 5) * cnt;
    }
}
