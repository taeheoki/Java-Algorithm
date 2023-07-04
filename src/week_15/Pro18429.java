package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 18429 - 근손실
 */
public class Pro18429 {
    static int N, K, cnt;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            used[i] = true;
            rec_func(1, 500 + arr[i] - K);
            used[i] = false;
        }
        System.out.println(cnt);
    }

    private static void rec_func(int depth, int power) {
        if (power < 500)
            return;
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i])
                continue;
            used[i] = true;
            rec_func(depth + 1, power + arr[i] - K);
            used[i] = false;
        }
    }
}
