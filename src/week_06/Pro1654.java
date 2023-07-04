package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1654번 랜선 자르기
 */
public class Pro1654 {
    static int K, N;
    static int[] LANS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        LANS = new int[K];
        for (int i = 0; i < K; i++) {
            LANS[i] = Integer.parseInt(br.readLine());
        }
        long left = 1;
        long right = Arrays.stream(LANS).max().getAsInt();
        long res = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (getCount(mid) >= N) {
                res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        System.out.println(res);
    }

    private static long getCount(long mid) {
        long cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += LANS[i] / mid;
        }
        return cnt;
    }
}
