package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 3980 - 선발 명단
 */
public class Pro3980 {
    static int T, res;
    static int[][] board = new int[11][11];
    static boolean[] used = new boolean[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Arrays.fill(used, false);
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            pro();
        }
    }

    private static void pro() {
        res = 0;
        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int depth, int score) {
        if (depth == 11) {
            res = Math.max(res, score);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (board[depth][i] == 0 || used[i])
                continue;
            used[i] = true;
            dfs(depth + 1, score + board[depth][i]);
            used[i] = false;
        }
    }
}
