package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 25304 - 영수증
 */
public class Pro25304 {
    static int X, N;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        b = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i] * b[i];
        }
        if (X == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
