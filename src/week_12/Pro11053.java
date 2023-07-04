package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * BOJ 11053 - 가장 긴 증가하는 부분 수열
 * 문제 이해: 수열이 주어졌을 때 가장 긴 증가하는 부분 수열의 길이를 구하라
 */
public class Pro11053 {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        // 최댓값(최대 길이) 탐색
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
