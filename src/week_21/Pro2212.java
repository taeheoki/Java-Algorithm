package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2212 - 센서
 */
public class Pro2212 {
    static int N, K;
    static int[] arr, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dist = new int[N - 1];
        for (int i = 1; i < N; i++) {
            dist[i - 1] = arr[i] - arr[i - 1];
        }
        Arrays.sort(dist);
        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += dist[i];
        }
        System.out.println(sum);
    }
}
