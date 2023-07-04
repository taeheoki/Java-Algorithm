package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 9613 - GCD 합
 */
public class Pro9613 {
    static StringBuilder sb = new StringBuilder();
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
            Arrays.sort(arr);
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += GCD(arr[i], arr[j]);
            }
        }
        sb.append(sum).append('\n');
    }

    private static int GCD(int small, int big) {
        if (big % small == 0)
            return small;
        return GCD(big % small, small);
    }
}
