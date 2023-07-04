package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 3079번 입국심사
 * 시간 복잡도: O(N * log(right) * log(N))
 */
public class Pro3079 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long left = 0;
        long right = (long) Arrays.stream(arr).max().getAsInt() * M;
        long res = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (getCount(mid) >= M) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    private static long getCount(long mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += mid / arr[i];
        }
        return cnt;
    }
}
