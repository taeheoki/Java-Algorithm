package src.week_04;

import java.io.*;
import java.util.*;

/**
 * 백준 15654번 N과 M(5)
 */
public class Pro15654 {
    static int N, M;
    static int[] arr, used;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new int[M];
        visited = new boolean[N];
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
                if (!visited[i]) {
                    visited[i] = true;
                    used[depth] = arr[i];
                    rec_func(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
