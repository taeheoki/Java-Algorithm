package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 20950 - 미술가 미미
 */
public class Pro20950 {
    static int N, res = Integer.MAX_VALUE;
    static int[] moon = new int[3];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        moon[0] = Integer.parseInt(st.nextToken());
        moon[1] = Integer.parseInt(st.nextToken());
        moon[2] = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        rec_func(0, 0, 0, 0, 0);
        System.out.println(res);
    }

    private static void rec_func(int index, int R, int G, int B, int k) {
        if (k >= 2) {
            int tr = R / k;
            int tg = G / k;
            int tb = B / k;
            int tsum = Math.abs(tr - moon[0]) + Math.abs(tg - moon[1]) + Math.abs(tb - moon[2]);
            res = Math.min(res, tsum);
        }
        if (k < 7) {
            for (int i = index; i < N; i++) {
                rec_func(i + 1, R + arr[i][0], G + arr[i][1], B + arr[i][2], k + 1);
            }
        }
    }
}
