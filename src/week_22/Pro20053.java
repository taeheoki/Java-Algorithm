package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 20053 - 최소, 최대 2
 */
public class Pro20053 {
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        sb.append(Arrays.stream(arr).min().getAsInt()).append(' ').append(Arrays.stream(arr).max().getAsInt()).append('\n');
    }
}
