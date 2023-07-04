package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17393 - 다이나믹 롤러
 */
public class Pro17393 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = N - 1;
            int res = left;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (A[i] >= B[mid]) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int cnt = res - i;
            sb.append(cnt).append(' ');
        }
        System.out.println(sb);
    }
}
