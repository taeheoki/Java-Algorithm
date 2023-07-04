package src.week_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 10816 - 숫자 카드 2
 */
public class Pro10816 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        used = new int[10000000 + 1 + 10000000];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            used[Integer.parseInt(st.nextToken()) + 10000000]++;
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(used[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
        }
        System.out.println(sb);
    }
}
