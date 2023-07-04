package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 3079 - 입국 심사
 * 문제 이해:
 * 시간 복잡도:
 */
public class Pro3079 {
    static int N, M;
    static int[] T;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, T[i]);
        }
        pro();
    }

    private static void pro() {
        long res = bSearch();
        System.out.println(res);
    }

    private static long bSearch() {
        long left = 1;
        long right = max * M;
        long res = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = getCount(mid);
            if (cnt >= M) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return (long) res;
    }

    private static long getCount(long mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += mid / T[i];
            if(cnt >= M)
                break;
        }
        return cnt;
    }
}
