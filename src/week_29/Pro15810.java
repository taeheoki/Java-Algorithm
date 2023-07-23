package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 15810 - 풍선 공장
 */
public class Pro15810 {
    static int N, M, min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        long left = 1;
        long right = 1000000000L * M;
        long res = right;
        while (left <= right) {
            long mid = (right + left) / 2;
            if (getCnt(mid) >= M) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    private static long getCnt(long mid) {
        long cnt = 0;
        for (int i : arr) {
            cnt += mid / i;
        }
        return cnt;
    }
}
