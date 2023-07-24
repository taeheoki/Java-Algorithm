package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1915 - 가장 큰 정사각형
 */
public class Pro1915 {
    static int n, m, max;
    static int[][] board, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String data = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = data.charAt(j) - '0';
            }
        }
        pro();
    }

    private static void pro() {
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max * max);
    }
}
