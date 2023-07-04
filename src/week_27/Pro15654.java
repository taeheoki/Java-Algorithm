package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 15654 - N과 M (5)
 */
public class Pro15654 {
    static StringBuilder res = new StringBuilder();
    static int N, M;
    static int[] arr, ans;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        Arrays.sort(arr);
        rec_func(0);
        System.out.println(res);
    }

    private static void rec_func(int depth) {
        if (depth == M) {
            for (int n : ans) {
                res.append(n).append(' ');
            }
            res.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i])
                continue;
            used[i] = true;
            ans[depth] = arr[i];
            rec_func(depth + 1);
            used[i] = false;
        }
    }
}
