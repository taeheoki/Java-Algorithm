package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11066 - 파일 합치기
 * 1. 풀고 싶은 가짜 문제 (i<= j)
 *    dp[i][j]: i번 ~ j번 파일을 하나로 합치는 최소 비용
 * 2. 가짜 문제를 풀면 진짜 문제를 풀 수 있는가?
 *    dp 배열을 가득 채울 수만 있다면? 진짜 문제에 대한 대답은 dp[1][K] 이다.
 * 3. 초기값은 어떻게 되는가?
 *    i == j 인 경우 0
 * 4-1. dp[i][j] 계산에 필요한 탐색 경우를 공톤점끼리 묶어 내기 (Partitioning)
 * 4-2. 묶어낸 부분의 정답을 dp 배열을 이용해서 빠르게 계산해보기
 * 4. 점화식 구해내기
 *    dp[i][j] = min{dp[i][k] + dp[k + 1][j] + (i ~ j 파일 총량), i <= k < j}
 */
public class Pro11066 {
    static StringBuilder sb = new StringBuilder();
    static int T, K;
    static int[] arr;
    static int[][] sum, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            K = Integer.parseInt(br.readLine());
            arr = new int[K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        preprocess();
        dp = new int[K + 1][K + 1];

        for (int len = 2; len <= K; len++) {
            for (int i = 1; i <= K - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[i][j]);
                }
            }
        }
        System.out.println(dp[1][K]);
    }

    private static void preprocess() {
        sum = new int[K + 1][K + 1];

        for (int i = 1; i <= K; i++) {
            for (int j = i; j <= K; j++) {
                sum[i][j] = sum[i][j - 1] + arr[j];
            }
        }
    }
}