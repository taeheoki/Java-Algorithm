package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 2805번 나무 자르기
 */
public class Pro2805 {
    static int N;
    static long M, ans = Integer.MIN_VALUE;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        pro();
        System.out.println(ans);
    }

    private static void pro() {
        Arrays.sort(A);
        ans = binary_search(A, 0, A[A.length - 1]);;
    }

    private static long binary_search(int[] A, int bottom, int top) {
        int res = bottom;
        while (bottom <= top) {
            int mid = (bottom + top) / 2;
            if (cutSum(mid) >= M) {
                res = mid;
                bottom = mid + 1;
            } else
                top = mid - 1;
        }
        return res;
    }

    private static long cutSum(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > mid)
                sum += A[i] - mid;
        }
        return sum;
    }
}
