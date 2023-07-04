package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1806 - 부분합
 * 문제 이해: 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이
 * 시간 복잡도: O(N)
 */
public class Pro1806 {
    static int N, S, res = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int sum = 0;
        int len = 1;
        int right = 0;
        for (int left = 1; left <= N; left++) {
            sum -= arr[left - 1];
            len--;
            while (right + 1 <= N && sum < S) {
                right++;
                len++;
                sum += arr[right];
            }
            if (sum >= S)
                res = Math.min(res, len);
        }
        if (res == Integer.MAX_VALUE)
            res = 0;
        System.out.println(res);
    }
}
