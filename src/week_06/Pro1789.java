package src.week_06;

import java.io.*;

/**
 * 백준 1789번 수들의 합
 */
public class Pro1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int left = 1; // 자연수의 시작 지점
        int right = 92681; // S의 최대값을 만족하는 마지막 자연수
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getSum(mid) <= S) {
                res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        System.out.println(res);
    }

    private static long getSum(int mid) {
        long sum = 0;
        for (int i = 1; i <= mid; i++) {
            sum += i;
        }
        return sum;
    }
}
// 1 + 2+ 3 +4 +5 +6 +7 +8
