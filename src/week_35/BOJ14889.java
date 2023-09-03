package src.week_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 14889 - 스타트와 링크
 */
public class BOJ14889 {
    static int N, res = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        used = new boolean[N];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec_func(0, 0);
        System.out.println(res);
    }

    private static void rec_func(int depth, int start) {
        if (depth == N / 2) {
            int firstTeam = 0;
            int secondTeam = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j)
                        continue;
                    if (used[i] && used[j])
                        firstTeam += board[i][j];
                    else if (!used[i] && !used[j])
                        secondTeam += board[i][j];
                }
            }
            res = Math.min(res, Math.abs(firstTeam - secondTeam));
            return;
        }
        for (int i = start; i < N; i++) {
            if (used[i])
                continue;
            used[i] = true;
            rec_func(depth + 1, i + 1);
            used[i] = false;
        }
    }
}
