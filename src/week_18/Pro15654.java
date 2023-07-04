package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 15654 - N과 M (5)
 */
public class Pro15654 {
    static StringBuilder sb = new StringBuilder();
    static StringBuilder ans = new StringBuilder();
    static int N, M;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        rec_func(0);
        System.out.println(ans);
    }

    private static void rec_func(int depth) {
        if (depth == M) {
            ans.append(sb).append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i])
                continue;
            used[i] = true;
            String tmp = String.valueOf(sb);
            sb.append(arr[i]).append(' ');
            rec_func(depth + 1);
            used[i] = false;
            sb = new StringBuilder(tmp);
        }
    }
}
