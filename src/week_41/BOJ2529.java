package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2529 - 부등호
 */
public class BOJ2529 {
    static int k;
    static int[] res;
    static char[] arr;
    static boolean[] used;
    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void pro() {
        for (int i = 0; i <= 9; i++) {
            res[0] = i;
            used[i] = true;
            rec_func(0);
            used[i] = false;
        }
        System.out.println(set.pollLast());
        System.out.println(set.pollFirst());
    }

    private static void rec_func(int depth) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k + 1; i++)
                sb.append(res[i]);
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (used[i])
                continue;
            if (arr[depth] == '>') {
                if (res[depth] > i) {
                    res[depth + 1] = i;
                    used[i] = true;
                    rec_func(depth + 1);
                    used[i] = false;
                } else
                    continue;
            } else {
                if (res[depth] < i) {
                    res[depth + 1] = i;
                    used[i] = true;
                    rec_func(depth + 1);
                    used[i] = false;
                } else
                    continue;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        res = new int[k + 1];
        used = new boolean[10];
    }
}
