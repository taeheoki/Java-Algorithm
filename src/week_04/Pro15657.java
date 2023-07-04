package src.week_04;

import java.io.*;
import java.util.*;

/**
 * 백준 15657번 N과 M(8)
 */
public class Pro15657 {
    static int N, M, cnt;
    static ArrayList<Integer> arr = new ArrayList<>();
    static Map<Integer, Integer> map = new TreeMap<>();
    static int[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (!map.containsKey(tmp)) {
                arr.add(tmp);
                map.put(tmp, 0);
                cnt++;
            }
        }
        Collections.sort(arr);
        rec_func(0, 0);
        System.out.println(sb);
    }

    private static void rec_func(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr.get(used[i]) + " ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i < cnt; i++) {
                used[depth] = i;
                rec_func(depth + 1, i);
                used[depth] = -1;
            }
        }
    }
}
