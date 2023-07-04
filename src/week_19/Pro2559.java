package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2559 - 수열
 */
public class Pro2559 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int right = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        int cnt = 1;
        for (int left = 0; left <= N - K; left++) {
            sum -= arr[left];
            cnt--;
            while (right + 1 <= N && cnt < K) {
                right++;
                sum += arr[right];
                cnt++;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
