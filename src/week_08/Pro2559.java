package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2559 - 수열
 * 문제 이해: 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보자.
 * 시간 복잡도: O(N - K + 1) -> 대략 O(N)
 */
public class Pro2559 {
    static int N, K, ans = Integer.MIN_VALUE;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int sum = 0;
        int right = 0;
        int cnt = 1;
        for (int left = 1; left <= N; left++) {
            sum -= arr[left - 1];
            cnt--;
            while (cnt < K && right + 1 <= N) {
                right++;
                cnt++;
                sum += arr[right];
            }
            if (cnt == K)
                ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
