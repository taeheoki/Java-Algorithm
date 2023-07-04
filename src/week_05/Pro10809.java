package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10809번 알파벳 찾기
 */
public class Pro10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] used = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (used[ch - 'a'] == 0)
                used[ch - 'a'] = i + 1;
        }
        for (int i = 0; i < used.length; i++) {
            System.out.print(used[i] - 1 + " ");
        }
    }
}
