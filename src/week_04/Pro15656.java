package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15656번 N과 M(7)
 */
public class Pro15656 {
    static int N, M;
    static int[] arr, used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        rec_func(0);
        System.out.println(sb);
    }

    private static void rec_func(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(used[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                used[depth] = arr[i];
                rec_func(depth + 1);
            }
        }
    }
}
