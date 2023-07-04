package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15650번 N과 M (2)
 */
public class Pro15650 {
    static int N, M;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N];
        rec_func(0, 0);
        System.out.println(sb);
    }

    private static void rec_func(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                if (used[i])
                    sb.append(i + 1 + " ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i < N; i++) {
                if (!used[i]) {
                    used[i] = true;
                    rec_func(depth + 1, i + 1);
                    used[i] = false;
                }
            }
        }
    }
}
