package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1553 - 도미노 찾기
 */

public class Pro1553 {
    static int cnt;
    static int[][] map = new int[8][7], dirs = {{1, 0}, {0, 1}};
    static boolean[][] dominos = new boolean[7][7];
    static boolean[][] visit = new boolean[8][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }
        rec_func(0, 0);
        System.out.println(cnt);
    }

    private static void rec_func(int y, int x) {
        if (y == 8) {
            cnt++;
            return;
        } else if (x == 7) {
            rec_func(y + 1, 0);
            return;
        }
        if (visit[y][x]) {
            rec_func(y, x + 1);
            return;
        }
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            if (ny >= 8 || nx >= 7)
                continue;
            if (visit[ny][nx])
                continue;
            if (dominos[map[y][x]][map[ny][nx]] || dominos[map[ny][nx]][map[y][x]]) {
                continue;
            }
            visit[ny][nx] = true;
            dominos[map[y][x]][map[ny][nx]] = true;
            rec_func(y, x + 1);
            visit[ny][nx] = false;
            dominos[map[y][x]][map[ny][nx]] = false;
        }
    }

}

