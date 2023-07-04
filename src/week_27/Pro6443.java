package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 6443 - 애너그램
 */
public class Pro6443 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] alphabets = new int[26];
    static char[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            Arrays.fill(alphabets, 0);
            String data = br.readLine();
            for (int i = 0; i < data.length(); i++) {
                alphabets[data.charAt(i) - 'a']++;
            }
            ch = new char[data.length()];
            dfs(0, data.length());
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int length) {
        if (depth == length) {
            sb.append(ch).append('\n');
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] == 0)
                continue;
            alphabets[i]--;
            ch[depth] = (char) ('a' + i);
            dfs(depth + 1, length);
            alphabets[i]++;
        }
    }
}
