package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11047 - 동전 0
 */
public class Pro11047 {
    static int N, K;
    static int[] arr, arr_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        arr_cnt = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        for (int i = N - 1; i >= 0; i--) {
            while (K >= arr[i] && K >= 0) {
                K -= arr[i];
                arr_cnt[i]++;
            }
        }
        int cnt = Arrays.stream(arr_cnt).sum();
        System.out.println(cnt);
    }
}
