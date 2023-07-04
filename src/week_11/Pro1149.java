package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1149 - RGB 거리
 * 문제 이해: - 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 *          - N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 *          - i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 *          1번 집부터 N 번 집이 순서대로 있을 때 집의 색을 칠해야한다. 위 규칙을 만족하는 집을 칠하는 비용의 최솟값을 구해보자.
 */
public class Pro1149 {
    static int N;
    static int[] dp;
    static int[][] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        colors = new int[N + 1][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int red = Integer.parseInt(st.nextToken());
        int green = Integer.parseInt(st.nextToken());
        int blue = Integer.parseInt(st.nextToken());
        colors[1] = new int[]{red, green, blue};
        dp[1] = minThree(colors[1][0], colors[1][1], colors[1][2]);
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            red = Integer.parseInt(st.nextToken());
            green = Integer.parseInt(st.nextToken());
            blue = Integer.parseInt(st.nextToken());
            colors[i] = new int[]{red, green, blue};
            colors[i][0] += Math.min(colors[i - 1][1], colors[i - 1][2]);
            colors[i][1] += Math.min(colors[i - 1][0], colors[i - 1][2]);
            colors[i][2] += Math.min(colors[i - 1][0], colors[i - 1][1]);
            dp[i] = minThree(colors[i][0], colors[i][1], colors[i][2]);
        }
        System.out.println(dp[N]);
    }

    private static int minThree(int a, int b, int c) {
        if (a < b) {
            if (a < c)
                return a;
            else
                return c;
        } else {
            if (b < c)
                return b;
            else
                return c;
        }
    }
}
