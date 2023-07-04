package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 10942 - 팬린드롬?
 * 문제 이해: 자연수 N개를 칠판에 적고 M번의 질문을 하는데,
 *          질문은 정수 S, E가 주어질 때 배열의 시작과 끝이라 할 때 이 배열이 팰린드롬을 이루는지 알아보자.
 */
public class Pro10942 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        pro();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j]) {
                    dp[i][j] = 1;
                    if (i + 1 < j && j - 1 > i && dp[i + 1][j - 1] == 0) {
                        dp[i][j] = 0;
                    }
                }
            }
        }
    }
}
