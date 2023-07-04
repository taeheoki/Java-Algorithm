package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11399 - ATML
 * 문제 이해: ATM 앞에 서있는 사람별로 인출하는데 걸리는 시간이 제각각이다.
 *          사람들이 줄을 서는 순서에 따라서 돈을 인출하는데 필요한 시간의 합이 달라진다.
 *          돈을 인출하는데 필요한 시간의 합이 최소가 될 때 이 값을 구하라.
 */
public class Pro11399 {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dp = new int[N];
        dp[0] = arr[0];
        int sum = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];
            sum += dp[i];
        }
        System.out.println(sum);
    }
}
