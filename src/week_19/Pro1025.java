package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1025 - 제곱수 찾기
 */
public class Pro1025 {
    static int N, M, res = - 1;
    static char[][] strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        strs = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                strs[i][j] = tmp.charAt(j);
            }
        }
        pro();
        System.out.println(res);
    }

    private static void pro() {
        for (int i = 0; i < N; i++) { // 행의 시작점
            for (int j = 0; j < M; j++) { // 열의 시작점
                for (int y = -N; y < N; y++) {
                    for (int x = -M; x < M; x++) {
                        if (x == 0 && y == 0)
                            continue;
                        rec_func(i, j, y, x, String.valueOf(strs[i][j]));
                    }
                }
            }
        }
    }

    private static void rec_func(int i, int j, int y, int x, String num) {
        int sqrt = (int) Math.sqrt(Integer.parseInt(num));
        if ((sqrt * sqrt) == Integer.parseInt(num)) {
            res = Math.max(res, Integer.parseInt(num));
        }
        int ni = i + y;
        int nj = j + x;
        method(y, x, num, ni, nj);
    }

    private static void method(int y, int x, String num, int ni, int nj) {
        if (ni < 0 || nj < 0 || ni >= N || nj >= M)
            return;
        rec_func(ni, nj, y, x, num + strs[ni][nj]);
    }
}
