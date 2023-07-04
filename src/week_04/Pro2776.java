package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2776번 암기왕
 */
public class Pro2776 {
    static int T, N, M;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                set.add(Integer.parseInt(st.nextToken()));
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (set.contains(tmp)) {
                    sb.append(1 + "\n");
                } else
                    sb.append(0 + "\n");
            }
            set.clear();
        }
        System.out.println(sb);
    }
}
