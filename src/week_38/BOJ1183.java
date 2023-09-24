package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1183 - 약속
 */
public class BOJ1183 {
    static int N, max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = a - b;
        }
        pro();
    }

    private static void pro() {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        if (N % 2 == 1)
            System.out.println(1);
        else
            System.out.println(Math.abs(arr[N / 2] - arr[N / 2 - 1]) + 1);
    }
}
