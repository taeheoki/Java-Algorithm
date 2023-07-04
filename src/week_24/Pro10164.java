package src.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 10164 - 격자상의 경로
 */
public class Pro10164 {
    static int N, M, K;
    static long[][] map;
    static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new long[N][M];
        if (K != 0) {
            que.add(new int[]{K % M == 0 ? K / M - 1 : K / M, K % M == 0 ? M - 1: K % M - 1});
        }
        que.add(new int[]{N - 1, M - 1});
        pro();
        System.out.println(map[N - 1][M - 1]);
    }

    private static void pro() {
        int y = 0;
        int x = 0;
        map[0][0] = 1;
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            // 출발점에서 pos 위치의 x좌표와 y좌표까지 초기화
            settingMap(y, x, pos);
            logic(y, x, pos);
            y = pos[0];
            x = pos[1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void logic(int y, int x, int[] pos) {
        for (int i = y + 1; i <= pos[0]; i++) {
            for (int j = x + 1; j <= pos[1]; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
    }

    private static void settingMap(int y, int x, int[] pos) {
        for (int i = y; i <= pos[0]; i++) {
            map[i][x] = map[y][x];
        }
        for (int i = x; i <= pos[1]; i++) {
            map[y][i] = map[y][x];
        }
    }
}
