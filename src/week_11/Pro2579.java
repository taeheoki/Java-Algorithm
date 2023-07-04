package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 2579 - 계단 오르기
 * 문제 이해: 계단을 밟아 올라가며 꼭대기까지 도착할 때, 밟은 계단의 점수의 전체 합을 구한다.
 *          1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 *          2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 *          3. 마지막 도착 게단은 반드시 밟아야 한다.
 */
public class Pro2579 {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        dp = new int[n];
        dp[0] = arr[0];
        if (n >= 2)
            dp[1] = arr[0] + arr[1];
        if (n >= 3)
            dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }
        System.out.println(dp[n - 1]);
    }
}
