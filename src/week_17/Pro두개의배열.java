package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 17124 - 두 개의 배열
 */
public class Pro두개의배열 {
    static int T;
    static int[] A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = new int[Integer.parseInt(st.nextToken())];
            B = new int[Integer.parseInt(st.nextToken())];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            pro();
            long sum = 0;
            for (int i = 0; i < C.length; i++) {
                sum += C[i];
            }
            System.out.println(sum);
        }
    }

    private static void pro() {
        Arrays.sort(A);
        Arrays.sort(B);
        C = new int[A.length];
        int k = 0;
        for (int i = 0; i < C.length; i++) {
            while (k + 1 < B.length && Math.abs(B[k] - A[i]) > Math.abs(B[k + 1] - A[i])) {
                k++;
            }
            C[i] = B[k];
        }
    }
}
