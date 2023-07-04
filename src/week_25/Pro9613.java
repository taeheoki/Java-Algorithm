package src.week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 9613 - GCD 합
 */
public class Pro9613 {
    static int t, n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            pro();
        }
    }

    private static void pro() {
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += getGCD(Math.max(arr[i], arr[j]), Math.min(arr[i], arr[j]));
            }
        }
        System.out.println(sum);
    }

    private static int getGCD(int a, int b) {
        if (a % b == 0)
            return b;
        return getGCD(b, a % b);
    }
}
