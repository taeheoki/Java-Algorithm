package src.week_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1654 - 랜선 자르기
 */
public class Pro1654 {
    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    private static void pro() {
        long left = 1;
        long right = Arrays.stream(arr).max().getAsInt();
        long res = left;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = getConut(mid);
            if (cnt < N) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    private static long getConut(long mid) {
        long cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += arr[i] / mid;
        }
        return cnt;
    }
}
