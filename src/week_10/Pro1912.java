package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1912 - 연속합
 * 문제 이해: n개의 정수로 이루어진 임의의 수열이 주어진다.
 *          연속된 몇 개의 수를 선택해서 구할수 있는 합 중 가장 큰 합을 구하려 한다.
 *          가장 큰 합을 구하라.
 */
public class Pro1912 {
    static int n, res;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dp = new int[n];
        dp[0] = arr[0];
        res = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }

//    private static void pro() {
//        int right = 0;
//        for (int left = right; left < n; left++) {
//            int sum = 0;
//            while (right + 1 <= n) {
//                sum += arr[right];
//                right++;
//                res = Math.max(res, sum);
//                if (sum <= 0)
//                    break;
//            }
//        }
//    }
}
