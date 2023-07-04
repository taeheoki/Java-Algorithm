package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2003 - 수들의 합 2
 */
public class Pro2003 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int sum = 0;
        int right = 0;
        int cnt = 0;
        for (int left = 1; left <= N; left++) {
            sum -= arr[left - 1];
            while (right + 1 <= N && sum < M) {
                right++;
                sum += arr[right];
            }
            if (sum == M)
                cnt++;
        }
        System.out.println(cnt);
    }
}
