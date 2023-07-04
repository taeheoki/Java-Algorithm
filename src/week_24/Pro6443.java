package src.week_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * BOJ 6443 - 애너그램
 */
public class Pro6443 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] alpha;
    static char[] chars;
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            chars = br.readLine().toCharArray();
            alpha = new int[26];
            for (int i = 0; i < chars.length; i++) {
                alpha[chars[i] - 'a']++;
            }
            rec_func(0, "");
            pq.stream().forEach(s -> sb.append(s).append('\n'));
            pq.clear();
        }
        System.out.println(sb);
    }

    private static void rec_func(int depth, String cmp) {
        if (depth == chars.length) {
            pq.add(cmp);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] == 0)
                continue;
            alpha[i]--;
            rec_func(depth + 1, cmp + (char) (i + 'a'));
            alpha[i]++;
        }
    }
}
