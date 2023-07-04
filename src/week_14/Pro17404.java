package src.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 17404 - RGB거리 2
 * 문제 이해: RGB 거리에 N개의 집이 있을 때 집의 색을 칠해야하는데, 집의 색을 칠하기 위한 규칙이 존재한다.
 *          - 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
 *          - N번 집의 색은 N - 1번, 1번 집의 색과 같이 않아야 한다.
 *          - i (2 <= i <= N - 1)번 집의 색은 i - 1, i + 1번 집의 색과 같지 않아야 한다.
 *          이렇게 집을 칠할 때 집을 칠하는 비용의 최솟값을 구해보자.
 */
public class Pro17404 {
    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            dp = new int[N + 1][3];
            dp[1][0] = dp[1][1] = dp[1][2] = 5000;
            dp[1][i] = arr[1][i];
            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                res = Math.min(res, dp[N][j]);
            }
        }
        System.out.println(res);
    }
}
