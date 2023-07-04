package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 18111 - 마인크래프트
 */
public class Pro18111 {
    static int N, M, B, max = 0, min = 256;
    static int[] v = {Integer.MAX_VALUE, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        for (int i = min; i <= max; i++)
            rec_func(0, 0, i, 0, B);
        System.out.println(v[0] + " " + v[1]);
    }

    private static void rec_func(int i, int j, int target, int time, int block) {
        if (block >= 0 && i == N) {
            if (v[0] >= time) {
                v[0] = time;
                v[1] = target;
            }
        } else if (i <= N - 1 && j <= M - 1) {
            if (v[0] < time)
                return;
            int one_time = 0;
            int two_time = 0;
            if (map[i][j] > target) {
                block += map[i][j] - target;
                two_time = 2 * (map[i][j] - target);
            }
            if (map[i][j] < target) {
                block -= target - map[i][j];
                one_time = target - map[i][j];
            }
            if (j + 1 < M)
                rec_func(i, j + 1, target, time + one_time + two_time, block);
            else
                rec_func(i + 1, 0, target, time + one_time + two_time, block);
        }
    }
}
