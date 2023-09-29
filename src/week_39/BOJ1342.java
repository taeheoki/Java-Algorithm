package src.week_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * BOJ 1342 - 행운의 문자열
 */
public class BOJ1342 {
    static int res;
    static int[] alphabets = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            alphabets[ch - 'a']++;
        }

        rec_func(0, str.length(), new StringBuilder(), ' ');

        System.out.println(res);
    }

    private static void rec_func(int depth, int size, StringBuilder sb, Character prev) {
        if (depth == size) {
            res++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] > 0 && prev != (char) (i + 'a')) {
                alphabets[i]--;
                char tmp = (char) (i + 'a');
                StringBuilder sbTmp = sb.append(tmp);
                rec_func(depth + 1, size, sbTmp, tmp);
                alphabets[i]++;
            }
        }
    }
}
