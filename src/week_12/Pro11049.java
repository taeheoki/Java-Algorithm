package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11049 - 행렬 곱셈 순서
 * 문제 이해: 먼저 곱할 행렬을 고려해서 가장 적게 연산하게 되는 값을 구하라
 *          1. 풀고 싶은 가짜 문제 (i <= j)
 *             dp[i][j]: i번 ~ j번까지의 행렬 곱셈 연산 횟수의 최솟값
 *
 *          2. 가짜 문제를 풀면 진짜 문제를 풀수 있는가?
 *             dp[1][N]
 *          3. 초기값은 어떻게 되는가?
 *             i == j 인 경우 0
 *          4. 점화식 구하기
 *             dp[i][j] = min(dp[i][k] + dp[k + 1][j] + order(i, j, k), (i <= k < j))
 */
public class Pro11049 {
    static int N;
    static int[][] dp, order, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][N + 1];

        for (int len = 2; len <= N; len++) { // 행렬의 길이
            for (int i = 1; i <= N - len + 1; i++) { // 시작 지점
                int j = i + len - 1; // 끝 지점
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1]);
                }
            }
        }
        System.out.println(dp[1][N]);
    }

}
